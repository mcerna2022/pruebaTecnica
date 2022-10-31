/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.client.response;

import com.prueba.tecnica.dto.client.Address;
import com.prueba.tecnica.dto.client.Name;
import com.prueba.tecnica.dto.resultado.Resultado;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class CreateClientResponse {
    
    
    
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private Address address;
    private String phone;
    
    private Resultado resultado;
    
}
