/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.carts.response;


import com.prueba.tecnica.dto.carts.request.ProductObjectAddCart;
import com.prueba.tecnica.dto.resultado.Resultado;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class AddCartObjectResponse {
    
   
    private int id;
    
    private int userId;
   
    private Date date;
    
    private List<ProductObjectAddCart> products;
   
    private Resultado resultado;
    
}
