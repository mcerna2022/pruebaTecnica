/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.config;

import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 *
 * @author HP
 */
public class TokenStore {
    
    
    
    private  static final InMemoryTokenStore tokenStore = new InMemoryTokenStore();
    
    
    public static InMemoryTokenStore storeToken(){
        return tokenStore;
    }
    
    
    
    
}
