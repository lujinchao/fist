package com.baidu.personal.fist.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-12 02:16:44
 */

@Component
@ConfigurationProperties(prefix = "fist.client")
@Data
public class ClientConfig {

    private String root;

    private String username;

    private String password;

}
