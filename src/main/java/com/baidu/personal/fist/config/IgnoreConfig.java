package com.baidu.personal.fist.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-12 18:10:59
 */

@Component
@ConfigurationProperties(prefix = "fist.ignores")
@Slf4j
@Data
public class IgnoreConfig {

    private List<String> suffixList;

    private List<String> prefixList;

    private List<String> nameList;

    public boolean ignore(String filePath) {
        Integer pointIndex = filePath.lastIndexOf(".");
        if (pointIndex != -1) {
            String curSuffix = filePath.substring(filePath.lastIndexOf("."));
            for (String suffix : suffixList) {
                if (suffix.equals(curSuffix)) {
                    return true;
                }
            }
        }
        String[] pathArray = filePath.split("/");
        for (String path : pathArray) {
            if (!path.isEmpty()) {
                for (String prefix : prefixList) {
                    if (path.startsWith(prefix)) {
                        return true;
                    }
                }
                for (String name : nameList) {
                    if (path.equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
