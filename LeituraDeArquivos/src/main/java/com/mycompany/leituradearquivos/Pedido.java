/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.leituradearquivos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dev.VyniIossi
 */
public class Pedido implements Serializable {
    
    public int order_id;
    public Double total;
    public String date;
   
    public List<ItensPedido> Itens;
}


