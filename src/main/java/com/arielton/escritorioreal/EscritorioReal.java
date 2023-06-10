/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.arielton.escritorioreal;

import Model.Categoria;
import Model.Despesa;
import Model.Recebivel;
import Model.Usuario;
import ModuloConexao.Mysql;
import Telas.Login;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Telas.TelaPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author ariel
 */
public class EscritorioReal {

    public static void main(String[] args) throws SQLException {
    Connection conexao = Mysql.conector();

//        TelaLogin telaLogin = new TelaLogin(conexao);
//        telaLogin.setSize(600, 400);
//        telaLogin.set();

           JFrame tela = new Login(conexao);
           tela.setVisible(true);
          
//          Despesa despesa = new Despesa(conexao);
//          ArrayList<Despesa> despesas = despesa.pesquisarPorCategoria("2023-02-01", "2023-10-01");

//        for (Despesa item : despesas) {
//            System.out.println("NOME: " + item.getDescricacao_item() + " - " + item.getData());
//        }
//        Categoria categoria = new Categoria(conexao,"","DESPESA");
//        for (Categoria item : categoria.buscarCategoria("DESPESA", "ARI")) {
//            System.out.println("NOME: " + item.getNome_categoria());
//        }


//        Recebivel recebivel = new Recebivel(conexao);
//        ArrayList<Recebivel> recebiveis = recebivel.pesquisarPorCategoria("2023-02-06", "2023-10-06");
//        
//                System.out.println(recebiveis.get(0).getCategoria().getId());
        // Usuario usuario = new Usuario(conexao, "Arielton", "123");
//        Categoria categoria = new Categoria(conexao, "TESTE CATEGORIA", "DESPESA");
//        categoria.criarCategoria();
//        ArrayList<Categoria> categorias = categoria.buscarCategoria("DESPESA");
//        categoria.setId(1);
//        categoria.apagarCategoria();
//        categoria.setNome_categoria("CATEGORIA UPDATE");
//        categoria.setTipo("RECEBIVEL");
//        categoria.atualizarCategoria();
//        System.out.println(categorias.get(0).getNome_categoria());
//        for (Categoria categoria : categorias) {
//            System.out.println("NOME: " + categoria.getNome_categoria());
//        }
    }
}
