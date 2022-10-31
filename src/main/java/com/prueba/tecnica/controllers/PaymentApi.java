/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.carts.request.PaymentRequest;
import com.prueba.tecnica.dto.carts.request.PaymentRequestProcess;
import com.prueba.tecnica.dto.carts.response.PaymentProcessResponse;
import com.prueba.tecnica.dto.carts.response.ViewCartsToPaymentResponse;

import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.payment.PaymentException;
import com.prueba.tecnica.services.ServicePayment;
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
@RequestMapping("/api/cart/payment")
public class PaymentApi {
    
   
    @Autowired
    private ServicePayment service;
    
    
   @RequestMapping(value="/carts", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<ViewCartsToPaymentResponse> cartsToPayment(@Valid @RequestBody PaymentRequest request) throws PaymentException{
        ViewCartsToPaymentResponse res=null;
        ResponseEntity<ViewCartsToPaymentResponse> response;
       try{
           res=service.viewCarts(request);
           if(res.getResultado().getCode().equals("1")){
               response=new  ResponseEntity<>(res, HttpStatus.OK); 
           }else{
                response= new ResponseEntity<>(res, HttpStatus.CONFLICT); 
           }
           
       }catch(Exception e){
           res=new ViewCartsToPaymentResponse();
           Resultado result= new Resultado();
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new PaymentException("Client exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
    
   @RequestMapping(value="/process", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody  
   public ResponseEntity<PaymentProcessResponse> process(@Valid @RequestBody PaymentRequestProcess request) throws PaymentException{
        PaymentProcessResponse res=new PaymentProcessResponse();
        ResponseEntity<PaymentProcessResponse> response;
        Resultado result= new Resultado();
       try{
           res.setProcess(Boolean.TRUE);
           result.setCode("1");
           result.setDescription("success");
           res.setResultado(result);
           response=new ResponseEntity<>(res, HttpStatus.OK);
       }catch(Exception e){
          
           
           result.setCode("-1");
           result.setDescription(e.getMessage());
           res.setResultado(result);
            response= new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           throw new PaymentException("Client exception: "+e.getMessage());
       }
       
        return response;
       
       
   } 
    
    
    
    
    
}
