/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.product;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 *
 * @author HP
 */


public class Rating {
    
    
    @SerializedName("rate")
   double rate;

   @SerializedName("count")
   int count;


    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getRate() {
        return rate;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    
}
