package com.baidu.personal.fist.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-12 02:10:12
 */

@Component
@ConfigurationProperties(prefix = "fist.server")
@Data
public class ServerConfig {

    private String root;

    private String host;

    private int port;

}
