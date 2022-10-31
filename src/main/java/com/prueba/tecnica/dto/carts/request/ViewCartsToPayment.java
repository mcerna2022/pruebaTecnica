/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.carts.request;


import com.prueba.tecnica.dto.ProductoToPayment;
import com.prueba.tecnica.dto.resultado.Resultado;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class ViewCartsToPayment {
    
    
     private List<ProductoToPayment> products;
     
     private Double totalValue;
     
    
     
     private int idCart;
    
}
