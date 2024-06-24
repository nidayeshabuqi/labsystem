package com.qfedu.labsystem.Properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.md5")
@Data
public class Salt {
    private String salt;
}
