/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.tecnica.dto.client.response;

import com.prueba.tecnica.dto.product.Product;
import com.prueba.tecnica.dto.resultado.Resultado;
import java.util.List;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class ProductcAllResponse {
    
    
    
    private List<Product> products;
    
    private Resultado result;
    
}
