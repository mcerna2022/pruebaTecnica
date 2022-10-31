package com.prueba.tecnica.config.util;


import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import org.springframework.beans.factory.annotation.Value;


@Component
@PropertySource("file:config/general.properties")
@Data
public class PropertiesUtil {
    
    
    @Value("${credential.oauth.user}")
    private String userOauth;
    @Value("${credential.oauth.pass}")
    private String passOauth;
    @Value("${client.id}")
    private String clientId;
    @Value("${secret.client}")
    private String secretClient;
    @Value("${feign.max.idle.time}")
    private Long maxIdleTime;

    
}
