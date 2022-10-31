package com.prueba.tecnica.dto.carts.response;

import com.prueba.tecnica.dto.carts.request.ViewCartsToPayment;
import com.prueba.tecnica.dto.resultado.Resultado;
import java.util.List;
import lombok.Data;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
@Data
public class ViewCartsToPaymentResponse {
    
    
    private List<ViewCartsToPayment> carts; 
    
     private Resultado resultado;
}
