/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.services;

import com.prueba.tecnica.clients.FakeStoreApiClient;
import com.prueba.tecnica.dto.carts.request.ClientLoginRequest;
import com.prueba.tecnica.dto.carts.response.ClientLoginResponse;
import com.prueba.tecnica.dto.client.response.CreateClientResponse;
import com.prueba.tecnica.dto.client.reuqest.CreateClientRequest;
import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.client.ClientExceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Slf4j
public class ServiceClient {
    
    
    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;
    
    
    public CreateClientResponse createClient(CreateClientRequest request) throws ClientExceptions{
        CreateClientResponse response= null;
        Resultado resultado=new Resultado();
        try{
            resultado.setCode("0");
            resultado.setDescription("create success");
            response=fakeStoreApiClient.createClient(request);
            response.setResultado(resultado);
        }catch(Exception e){
           response= new CreateClientResponse();  
           resultado.setCode("-1");
           resultado.setDescription("Client exception: "+e.getMessage());
           log.debug("Client exception: "+e.getMessage());
           throw new ClientExceptions("Client exception: "+e.getMessage());
           
        }
        
        return response;
        
    }
    
    
    public ClientLoginResponse login(ClientLoginRequest request) throws ClientExceptions{
        ClientLoginResponse response= null;
        Resultado resultado=new Resultado();
        try{
            resultado.setCode("0");
            resultado.setDescription("create success");
            response=fakeStoreApiClient.loginClient(request);
            response.setResultado(resultado);
        }catch(Exception e){
           response= new ClientLoginResponse();  
           resultado.setCode("-1");
           resultado.setDescription("Client exception: "+e.getMessage());
           log.debug("Client exception: "+e.getMessage());
           throw new ClientExceptions("Client exception: "+e.getMessage());
           
        }
        
        return response;
        
    }
    
   
    
}
