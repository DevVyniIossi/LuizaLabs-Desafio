/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.leituradearquivos;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev.VyniIossi
 */
public class LeituraDeArquivos {

    public static void main(String[] args) {
        
        FileInputStream stream;
// Sequencia de comando responsável pela leitura do arquivo TXT.
        try {
// Para realizar a leitura do outro arquivo TXT, alterar abaixo o diretório do arquivo.
            stream = new FileInputStream("C:\\desafio\\data_2.txt"); 
            
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            String linha = br.readLine();
            
            List<PedidoDoUsuario> pedidos = new ArrayList<>();
            
            while(linha != null) {
                
                if (linha != null)
                {
                    String idUsuario = linha.substring(0, 10);
                    String nome = linha.substring(10, 55).trim();
                    String idPedido = linha.substring(55, 66);
                    String idProduto  = linha.substring(66, 75);
                    Double valorProduto = Double.parseDouble(linha.substring(75, 87));
                    String dataDaCompra = linha.substring(87, 95);
                    
                    PedidoDoUsuario pedidoDoUsuario = new PedidoDoUsuario();
                    pedidoDoUsuario.user_id = Integer.parseInt(idUsuario);
                    pedidoDoUsuario.name = nome;
                    pedidoDoUsuario.Pedidos = new ArrayList<>();
                    
                    var pedido = new Pedido();
                    pedido.date = dataDaCompra;
                    pedido.order_id = Integer.parseInt(idPedido);
                    pedido.total = valorProduto;
                    
                    pedido.Itens =  new ArrayList<>();
                    
                    var item = new ItensPedido();
                    item.product_id = Integer.parseInt(idProduto);
                    item.value = valorProduto;
                    
                    pedido.Itens.add(item);
                    pedidoDoUsuario.Pedidos.add(pedido);
                    pedidos.add(pedidoDoUsuario);
                }
// Final da Sequencia de comando responsável pela leitura do arquivo TXT.               
                linha = br.readLine();
            }
            
            Gson gson = new Gson();
            String json = gson.toJson(pedidos);
//Pasta Destinatária para retorono de Arquivo JSON.
            FileWriter myWriter = new FileWriter("C:\\desafio\\retornoJson2.txt"); 
            myWriter.write(json);
            myWriter.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportacaoDeArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportacaoDeArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
