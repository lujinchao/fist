package com.baidu.personal.fist;

import com.baidu.personal.fist.client.ClientMain;
import com.baidu.personal.fist.server.ServerMain;
import com.baidu.personal.fist.utils.CommandLineUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@Slf4j
@SpringBootApplication
public class FistApplication {

    static final String SERVER = "server";

    static final String CLIENT = "client";

    public static void main(String[] args) throws Exception {
        CommandLine commandLine = CommandLineUtil.parseCommandLine(args);
        String startType = commandLine.getOptionValue("mode");
        boolean initialize = commandLine.hasOption("initialize");
        if (!SERVER.equals(startType) && !CLIENT.equals(startType)) {
            log.error("fist must be started with mode server or client");
            System.exit(1);
        }
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FistApplication.class, args);
        if (SERVER.equals(startType)) {
            log.info("start fist with mode server");
            ServerMain serverMain = applicationContext.getBean(ServerMain.class);
            serverMain.run();
        }
        else if (CLIENT.equals(startType)) {
            log.info("start fist with mode client");
            ClientMain clientMain = applicationContext.getBean(ClientMain.class);
            clientMain.run(initialize);
        }
    }

}
