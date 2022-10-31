/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.carts.request;

import com.google.gson.annotations.SerializedName;



/**
 *
 * @author HP
 */

public class Products {
   
    
   @SerializedName("productId")
   int productId;

   @SerializedName("quantity")
   int quantity;


    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getProductId() {
        return productId;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    
    
    
    
}
