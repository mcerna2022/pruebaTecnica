/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.clients;

import com.prueba.tecnica.config.FooClientConfig;
import com.prueba.tecnica.dto.carts.request.AddCartRequest;
import com.prueba.tecnica.dto.carts.request.ClientLoginRequest;
import com.prueba.tecnica.dto.carts.response.AddCartObjectResponse;
import com.prueba.tecnica.dto.carts.response.AddCartsResponse;
import com.prueba.tecnica.dto.carts.response.ClientLoginResponse;
import com.prueba.tecnica.dto.client.response.CreateClientResponse;
import com.prueba.tecnica.dto.client.response.ProductcAllResponse;
import com.prueba.tecnica.dto.client.reuqest.CreateClientRequest;
import com.prueba.tecnica.dto.product.Product;
import feign.Headers;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author HP
 */
@FeignClient(name = "fakestore-operation", url = "${fake.store.url}", configuration = FooClientConfig.class)
@Headers("Accept: application/json")
public interface FakeStoreApiClient {
    
    
    
    
    
    @PostMapping("${fake.store.method.user.create}")
    public CreateClientResponse createClient(@RequestBody CreateClientRequest request);
    
    
    @GetMapping("${fake.store.method.all.products}")
    public Product[] allProducts();
    
    
    @PostMapping("${fake.store.method.add.carts}")
    public AddCartObjectResponse addCarts(AddCartRequest request);
    
    @PutMapping("${fake.store.method.add.carts}/{idCart}")
    public AddCartObjectResponse updateCarts(AddCartRequest request,@PathVariable("idCart") int idCart);
    
    @PutMapping("${fake.store.method.add.carts}/{idCart}")
    public AddCartObjectResponse deleteCarts(@PathVariable("idCart") int idCart);
    
    
    @PostMapping("${fake.store.login.method}")
    public ClientLoginResponse loginClient(@RequestBody ClientLoginRequest request);
    
    @GetMapping("${fake.store.method.add.carts}/user/{userId}")
    public AddCartsResponse[] cartsUser(@PathVariable("userId")int userId);
    
    
    @GetMapping("${fake.store.method.all.products}/{idProduct}")
    public Product SingleProduct(@PathVariable("idProduct") int idProduct);
    
}
