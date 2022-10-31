/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.services;

import com.prueba.tecnica.clients.FakeStoreApiClient;
import com.prueba.tecnica.dto.carts.request.AddCartRequest;
import com.prueba.tecnica.dto.carts.request.UpdateCartRequest;
import com.prueba.tecnica.dto.carts.response.AddCartObjectResponse;

import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.carts.CartsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Slf4j
@Service
public class ServiceCarts {
    
    
    
    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;
    
    
    public AddCartObjectResponse addCarts(AddCartRequest request) throws CartsException{
        AddCartObjectResponse response= null;
        Resultado resultado=new Resultado();
        try{
            resultado.setCode("0");
            resultado.setDescription("add success");
            response=fakeStoreApiClient.addCarts(request);
            response.setResultado(resultado);
        }catch(Exception e){
           response= new AddCartObjectResponse();  
           resultado.setCode("-1");
           resultado.setDescription("Carts exception: "+e.getMessage());
           log.debug("Client exception: "+e.getMessage());
           throw new CartsException("Carts exception: "+e.getMessage());
           
        }
        
        return response;
        
    }
    
    
    public AddCartObjectResponse updateCarts(UpdateCartRequest request) throws CartsException{
        AddCartObjectResponse response= null;
        Resultado resultado=new Resultado();
        try{
            resultado.setCode("0");
            resultado.setDescription("update success");
            AddCartRequest req= new AddCartRequest();
            req.setDate(request.getDate());
            req.setProducts(request.getProducts());
            req.setUserId(request.getUserId());
            response=fakeStoreApiClient.updateCarts(req,request.getId());
            response.setResultado(resultado);
        }catch(Exception e){
           response= new AddCartObjectResponse();  
           resultado.setCode("-1");
           resultado.setDescription("Carts exception: "+e.getMessage());
           log.debug("Client exception: "+e.getMessage());
           throw new CartsException("Carts exception: "+e.getMessage());
           
        }
        
        return response;
        
    }
    
     public AddCartObjectResponse deleteCarts(int id) throws CartsException{
        AddCartObjectResponse response= null;
        Resultado resultado=new Resultado();
        try{
            resultado.setCode("0");
            resultado.setDescription("delete success");
            
           
            response=fakeStoreApiClient.deleteCarts(id);
            response.setResultado(resultado);
        }catch(Exception e){
           response= new AddCartObjectResponse();  
           resultado.setCode("-1");
           resultado.setDescription("Carts exception: "+e.getMessage());
           log.debug("Client exception: "+e.getMessage());
           throw new CartsException("Carts exception: "+e.getMessage());
           
        }
        
        return response;
        
    }
    
    
}
