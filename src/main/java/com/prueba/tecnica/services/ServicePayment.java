/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.services;

import com.prueba.tecnica.clients.FakeStoreApiClient;
import com.prueba.tecnica.dto.ProductoToPayment;
import com.prueba.tecnica.dto.carts.request.AddCartRequest;
import com.prueba.tecnica.dto.carts.request.PaymentRequest;
import com.prueba.tecnica.dto.carts.request.Products;
import com.prueba.tecnica.dto.carts.request.ViewCartsToPayment;
import com.prueba.tecnica.dto.carts.response.AddCartsResponse;
import com.prueba.tecnica.dto.carts.response.ViewCartsToPaymentResponse;
import com.prueba.tecnica.dto.product.Product;
import com.prueba.tecnica.dto.resultado.Resultado;
import com.prueba.tecnica.exception.payment.PaymentException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Slf4j
@Service
public class ServicePayment {
    
    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;
    
     public ViewCartsToPaymentResponse viewCarts(PaymentRequest request) throws PaymentException{
        
        ViewCartsToPaymentResponse response= new ViewCartsToPaymentResponse();
        Resultado resultado=new Resultado();
        
        try{
            resultado.setCode("0");
            resultado.setDescription("update success");
            
            AddCartsResponse[] list=fakeStoreApiClient.cartsUser(Integer.valueOf(request.getUserId()));
            if(list!=null && list.length>0){
                List<ViewCartsToPayment> carts= new ArrayList<>();
                Double totalValue=0.0;
                for(AddCartsResponse obj:list){
                    ViewCartsToPayment viewCarts= new ViewCartsToPayment();
                    List<ProductoToPayment> productsAdd=new ArrayList<>();
                    if(obj.getProducts()!=null && !obj.getProducts().isEmpty()){
                        for(Products pr:obj.getProducts()){
                            Product product=  fakeStoreApiClient.SingleProduct(pr.getProductId());  
                            ProductoToPayment add=new ProductoToPayment();
                            add.setCantidad(pr.getQuantity());
                            add.setDescription(product.getDescription());
                           
                            add.setUnitvalue(product.getPrice());
                            add.setTotalvalueItem(product.getPrice()*pr.getQuantity());
                            productsAdd.add(add);
                            totalValue=totalValue+add.getTotalvalueItem();
                            viewCarts.setProducts(productsAdd);
                        }
                        viewCarts.setTotalValue(totalValue);
                        carts.add(viewCarts);
                        totalValue=0.0;
                    }
                
                }
                
                response.setCarts(carts);
            }
            response.setResultado(resultado);
        }catch(Exception e){
           response= new ViewCartsToPaymentResponse();  
           resultado.setCode("-1");
           resultado.setDescription("payment exception: "+e.getMessage());
           log.debug("payment exception: "+e.getMessage());
           throw new PaymentException("payment exception: "+e.getMessage());
           
        }
        
        return response;
        
    }
    
    
    
    
}
