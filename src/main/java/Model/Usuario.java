/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ariel
 */
public class Usuario {
    Connection conexao;
    private String nome;
    private String senha;
    private int id = 0;

    public Usuario(Connection conexao, String nome, String senha) {
        this.conexao = conexao;
        this.nome = nome;
        this.senha = senha;
    }
    
    public boolean criarUsuario() {
        try {
            if(!buscarUsuarioNome().isEmpty()) return false;
            
            String sql = "INSERT INTO `escritorio_real`.`usuarios` (`nome`, `senha`) VALUES (?, ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Usuario!");
            return false;
        }
    }
    
    public boolean atualizarUsuario() {
        try {
            String sql = "UPDATE `escritorio_real`.`usuarios` SET `nome` = ?, `senha` = ? WHERE (`id` = ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.setInt(3, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Usuario!");
            return false;
        }
    }
    
    public boolean apagarUsuario() {
        try {
            String sql = "DELETE FROM `escritorio_real`.`usuarios` WHERE (`id` = ?);";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao apagar Usuario!");
            return false;
        }
    }
    
    public boolean buscarUsuario() {
        try {
            String sql = "SELECT * FROM `escritorio_real`.`usuarios` WHERE nome = ? and senha = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                id = rs.getInt("id");
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Usuario!");
            return false;
        }
    }
    
    public String buscarUsuarioNome() {
        try {
            String sql = "SELECT * FROM `escritorio_real`.`usuarios` WHERE nome = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                return rs.getString("nome");
            }

            return "";
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Usuario!");
            return "";
        }
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
