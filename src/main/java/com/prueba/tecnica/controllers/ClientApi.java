/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.carts.request.ClientLoginRequest;
import com.prueba.tecnica.dto.carts.response.ClientLoginResponse;
import com.prueba.tecnica.dto.client.response.CreateClientResponse;
import com.prueba.tecnica.dto.client.reuqest.CreateClientRequest;
import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.client.ClientExceptions;
import com.prueba.tecnica.services.ServiceClient;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api/cart/client")
public class ClientApi {
    
   @Autowired
   private ServiceClient serviceClient;
   
   @RequestMapping(value="/create", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<CreateClientResponse> create(@Valid @RequestBody CreateClientRequest request) throws ClientExceptions{
        CreateClientResponse res=null;
        ResponseEntity<CreateClientResponse> response;
       try{
           res=serviceClient.createClient(request);
           if(res.getResultado().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new CreateClientResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new ClientExceptions("Client exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
   
   
   @RequestMapping(value="/login", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<ClientLoginResponse> login(@Valid @RequestBody ClientLoginRequest request) throws ClientExceptions{
        ClientLoginResponse res=null;
        ResponseEntity<ClientLoginResponse> response;
       try{
           res=serviceClient.login(request);
           if(res.getResultado().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new ClientLoginResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new ClientExceptions("Client exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
    
    
    
}
