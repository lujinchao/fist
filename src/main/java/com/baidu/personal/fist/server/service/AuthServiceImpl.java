package com.baidu.personal.fist.server.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baidu.personal.fist.config.ClientConfig;
import com.baidu.personal.fist.grpc.AuthMsg;
import com.baidu.personal.fist.grpc.AuthServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-15 14:10:35
 */

@Component
@Slf4j
public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {

    static final String SECRET = "_FIST_PRIVATE_KEY_";

    static final String ISSUER = "FIST";

    @Autowired
    private ClientConfig clientConfig;

    @Override
    public void authenticate(AuthMsg.Credit request, StreamObserver<AuthMsg.Result> responseObserver) {

        String username = request.getUsername();
        String password = request.getPassword();

        AuthMsg.Result result;
        if (clientConfig.getUsername().equalsIgnoreCase(username) &&
                clientConfig.getPassword().equalsIgnoreCase(password)) {
            result = AuthMsg.Result.newBuilder()
                    .setSuccess(true)
                    .setMsg("ok")
                    .setToken(generateToken(username, password))
                    .build();
        } else {
            result = AuthMsg.Result.newBuilder().setSuccess(false).setMsg("authenticate fail").build();
        }
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    private String generateToken(String username, String password) {
        Algorithm algorithm;
        try {
            algorithm = Algorithm.HMAC256(SECRET);
        } catch (UnsupportedEncodingException exception) {
            throw new RuntimeException(exception);
        }
        return JWT.create().withIssuer(ISSUER).withClaim("username", username)
                .withClaim("password", password).sign(algorithm);
    }
}
