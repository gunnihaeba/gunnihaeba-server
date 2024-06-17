package com.gunni.gunnihaeba.global.security.jwt.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JwtProperties {
    private String secretKey;
    private String header;
    private String prefix;
    private Long accessExp;
    private Long refreshExp;

}
