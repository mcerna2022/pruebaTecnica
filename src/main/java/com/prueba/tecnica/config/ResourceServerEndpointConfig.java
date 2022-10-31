///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prueba.tecnica.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author HP
// */
//@Configuration
//public class ResourceServerEndpointConfig extends ResourceServerConfigurerAdapter{
//    
// private static final String SERVER_RESOURCE_ID = "oauth2-server";   
//    
//  @Override
//        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//            resources.tokenStore(TokenStore.storeToken()).resourceId(SERVER_RESOURCE_ID);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.requestMatchers().antMatchers("/api").and()
//                    .authorizeRequests().antMatchers("/api").access("#oauth2.hasScope('all')");
//        }
//    
//    
//    
//}
