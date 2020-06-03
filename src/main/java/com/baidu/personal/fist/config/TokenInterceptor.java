package com.baidu.personal.fist.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.internal.NoopServerCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-15 13:35:08
 */

@Component
@Slf4j
public class TokenInterceptor implements ServerInterceptor {

    static final String SECRET = "_FIST_PRIVATE_KEY_";

    static final String ISSUER = "FIST";

    static final String TOKEN_ENDPOINT = "com.baidu.personal.fist.grpc.AuthService/authenticate";

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
        String fullMethodName = serverCall.getMethodDescriptor().getFullMethodName();
        if (TOKEN_ENDPOINT.equals(fullMethodName)) {
            return serverCallHandler.startCall(serverCall, metadata);
        }
        String token = metadata.get(Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER));
        if (!checkToken(token)) {
            serverCall.close(Status.PERMISSION_DENIED, metadata);
            return new NoopServerCall.NoopServerCallListener<>();
        }
        return serverCallHandler.startCall(serverCall, metadata);
    }

    private boolean checkToken(String token) {
        Algorithm algorithm;
        try {
            algorithm = Algorithm.HMAC256(SECRET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception exception) {
            log.info("token verify error, please check username and password");
            return false;
        }
        return true;
    }
}
