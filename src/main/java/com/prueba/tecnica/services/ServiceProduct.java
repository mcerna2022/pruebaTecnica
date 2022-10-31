/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.services;

import com.google.gson.Gson;
import com.prueba.tecnica.clients.FakeStoreApiClient;
import com.prueba.tecnica.dto.client.response.ProductcAllResponse;
import com.prueba.tecnica.dto.product.Product;
import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.product.ProductException;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Slf4j
public class ServiceProduct {
    
    
    
    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;
    
    
    public ProductcAllResponse all() throws ProductException{
        
        ProductcAllResponse response=new ProductcAllResponse();
        Resultado result= new Resultado();
        Gson gs= new Gson();
        try{
            
            Product[] okl=fakeStoreApiClient.allProducts();
            
        
            if(okl!=null&& okl.length>0){
                
                List<Product> all= Arrays.asList(okl);
                response.setProducts(all);
            }
            
            
            result.setCode("1");
            result.setDescription("view all products");
            response.setResult(result);
        }catch(Exception e){
            
            result.setCode("-1");
            result.setDescription("Product exception: "+e.getMessage());
           log.debug("Client exception: "+e.getMessage());
           throw new ProductException("Product exception: "+e.getMessage());
        }
        
        return response;
    }
    
}
