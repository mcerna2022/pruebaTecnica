package com.prueba.tecnica.config;



import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.prueba.tecnica.config.util.PropertiesUtil;

import feign.codec.Decoder;
import feign.httpclient.ApacheHttpClient;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientFactory;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;

@Configuration
public class FooClientConfig {
    
    
       @Autowired
       PropertiesUtil props;

	@Bean
	public Decoder feignDecoder() {
		HttpMessageConverter<?> jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
		ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
		return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setObjectMapper(customObjectMapper());
	    return converter;
	}

	@Bean
	public RestTemplate createRestTemplate() {
		ObjectMapper objectMapper = customObjectMapper();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, converter);
		return restTemplate;
	}

	@Bean
	public ObjectMapper customObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		return objectMapper;
	}
        
         @Bean
    public ApacheHttpClient feignClient(ApacheHttpClientFactory httpClientFactory,
            HttpClientConnectionManager httpClientConnectionManager,
            FeignHttpClientProperties httpClientProperties) {
        RequestConfig defaultRequestConfig = RequestConfig
                .custom()
                .setConnectTimeout(httpClientProperties.getConnectionTimeout())
                .setRedirectsEnabled(httpClientProperties.isFollowRedirects())
                .build();
        CloseableHttpClient httpClient = httpClientFactory
                .createBuilder()
                .setConnectionManager(httpClientConnectionManager)
                .setDefaultRequestConfig(defaultRequestConfig)
                .evictIdleConnections(this.props.getMaxIdleTime(), TimeUnit.MILLISECONDS)
                .evictExpiredConnections()
                .build();

        return new ApacheHttpClient(httpClient);
    }
}
