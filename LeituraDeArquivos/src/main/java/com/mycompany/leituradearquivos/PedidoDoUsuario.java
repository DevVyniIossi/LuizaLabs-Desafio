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
public class PedidoDoUsuario implements Serializable {
    
    public int user_id;
    public String name;
    public List<Pedido> Pedidos;
}
