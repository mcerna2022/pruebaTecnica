/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class Geolocation {
    
    
    private String lat;
    @JsonProperty("long") 
    private String mylong;
    
}
