/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.carts.response;

import com.prueba.tecnica.dto.resultado.Resultado;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class ClientLoginResponse {
    
    
    private String token;
    
    private Resultado resultado;
    
    
    
    
}
