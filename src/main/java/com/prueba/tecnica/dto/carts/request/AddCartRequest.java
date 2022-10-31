/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.carts.request;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class AddCartRequest {
    
    private String userId;
    
    private Date date;
    
    private List<Products> products;
    
}
