/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto;

import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class ProductoToPayment {
    
    
    private int idProduct;
    
    private int cantidad;
    
    private String description;
    
    private Double unitvalue;
    
    private Double totalvalueItem;
    
   
    
}
