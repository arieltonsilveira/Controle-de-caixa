/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ariel
 */
public class Categoria {
    private int id;
    private String nome_categoria;
    private String tipo;
    Connection conexao;

    public Categoria(int id, String nome_categoria, String tipo) {
        this.id = id;
        this.nome_categoria = nome_categoria;
        this.tipo = tipo;
    }    

    public Categoria(Connection conexao, String nome_categoria, String tipo) {
        this.nome_categoria = nome_categoria;
        this.tipo = tipo;
        this.conexao = conexao;
    }
    
    public boolean criarCategoria() {
        try {
            if(!buscarCategoriaNome().isEmpty()) return false;
            
            String sql = "INSERT INTO `escritorio_real`.`categoria` (`nome_categoria`, `tipo`) VALUES (?, ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome_categoria);
            pst.setString(2, tipo);
            pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean atualizarCategoria() {
        try {
            String sql = "UPDATE `escritorio_real`.`categoria` SET `nome_categoria` = ?, `tipo` = ? WHERE (`id` = ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome_categoria);
            pst.setString(2, tipo);
            pst.setInt(3, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Categoria!");
            return false;
        }
    }
    
    public boolean apagarCategoria() {
        try {
            // Validar se a categoria esta em Uso;
            if (false) {
                
            }
            
            String sql = "DELETE FROM `escritorio_real`.`categoria` WHERE (`id` = ?);";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao apagar Categoria!");
            return false;
        }
    }
    
    public ArrayList<Categoria> buscarCategoria(String tipo) {
        try {
            String sql = "SELECT * FROM `escritorio_real`.`categoria` WHERE tipo = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, tipo);
            ResultSet rs = pst.executeQuery();
            
            ArrayList categorias = new ArrayList<>();
            
            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome_categoria"),
                        rs.getString("tipo")
                    )
                );
            }

            return categorias;
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar categoria por tipo!" + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Categoria> buscarCategoria(String tipo, String nome_categoria) {
        try {
            String sql = "SELECT * FROM `escritorio_real`.`categoria` WHERE tipo = ? and nome_categoria like ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, "%" + nome_categoria + "%");
            
            ResultSet rs = pst.executeQuery();
            
            ArrayList categorias = new ArrayList<>();
            
            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome_categoria"),
                        rs.getString("tipo")
                    )
                );
            }

            return categorias;
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar categoria por tipo!" + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public String buscarCategoriaNome() {
        try {
            String sql = "SELECT * FROM `escritorio_real`.`categoria` WHERE nome_categoria = ? and tipo = ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome_categoria);
            pst.setString(2, tipo);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                return rs.getString("nome_categoria");
            }

            return "";
        } catch (SQLException e) {
            System.out.println("Erro ao buscar nome da categoria!");
            return "";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
