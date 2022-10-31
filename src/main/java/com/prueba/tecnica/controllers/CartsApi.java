/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.carts.request.AddCartRequest;
import com.prueba.tecnica.dto.carts.request.UpdateCartRequest;
import com.prueba.tecnica.dto.carts.response.AddCartObjectResponse;
import com.prueba.tecnica.dto.carts.response.AddCartsResponse;

import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.carts.CartsException;
import com.prueba.tecnica.services.ServiceCarts;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api/cart")
public class CartsApi {
    
    
   @Autowired
   private ServiceCarts serviceCarts;
   
   
   @RequestMapping(value="/add", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<AddCartObjectResponse> create(@Valid @RequestBody AddCartRequest request) throws CartsException{
        AddCartObjectResponse res;
        ResponseEntity<AddCartObjectResponse> response;
       try{
           res=serviceCarts.addCarts(request);
           if(res.getResultado().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new AddCartObjectResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new CartsException("Carts exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
   
   
   @RequestMapping(value="/update", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<AddCartObjectResponse> update(@Valid @RequestBody UpdateCartRequest request) throws CartsException{
        AddCartObjectResponse res;
        ResponseEntity<AddCartObjectResponse> response;
       try{
           res=serviceCarts.updateCarts(request);
           if(res.getResultado().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new AddCartObjectResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new CartsException("Carts exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
   
   
   
   @RequestMapping(value="/delete", method = RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<AddCartObjectResponse> delete(@RequestParam(name = "idCart") int idCart) throws CartsException{
        AddCartObjectResponse res;
        ResponseEntity<AddCartObjectResponse> response;
       try{
           res=serviceCarts.deleteCarts(idCart);
           if(res.getResultado().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new AddCartObjectResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new CartsException("Carts exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
}
