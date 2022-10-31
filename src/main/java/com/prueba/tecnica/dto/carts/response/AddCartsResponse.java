/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.carts.response;


import com.google.gson.annotations.SerializedName;
import com.prueba.tecnica.dto.carts.request.Products;


import java.util.Date;
import java.util.List;




/**
 *
 * @author HP
 */

public class AddCartsResponse {
  
   @SerializedName("id")
   int id;

   @SerializedName("userId")
   int userId;

   @SerializedName("date")
   Date date;

   @SerializedName("products")
   List<Products> products;

   @SerializedName("__v")
   int _v;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    
    public void setProducts(List<Products> products) {
        this.products = products;
    }
    public List<Products> getProducts() {
        return products;
    }
    
    public void set_v(int _v) {
        this._v = _v;
    }
    public int get_v() {
        return _v;
    }

  
    
    
    
    
}
