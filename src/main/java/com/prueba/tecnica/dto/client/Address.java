/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.client;

import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class Address {
    
    
    
    public String city;
    public String street;
    public int number;
    public String zipcode;
    public Geolocation geolocation;
    
}
