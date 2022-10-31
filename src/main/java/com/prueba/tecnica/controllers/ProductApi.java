/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.client.response.ProductcAllResponse;
import com.prueba.tecnica.dto.resultado.Resultado;

import com.prueba.tecnica.exception.product.ProductException;
import com.prueba.tecnica.services.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api/cart/product")
public class ProductApi {
    
    
    @Autowired
    private ServiceProduct serviceProduct;       
    
    
    
   @RequestMapping(value="/all", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<ProductcAllResponse> all() throws ProductException{
        ProductcAllResponse res=null;
        ResponseEntity<ProductcAllResponse> response;
       try{
           res=serviceProduct.all();
           if(res.getResult().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new ProductcAllResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResult(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new ProductException("Client exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
   
   
   
    
}
