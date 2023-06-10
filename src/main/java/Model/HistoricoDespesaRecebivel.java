/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ariel
 */
public class HistoricoDespesaRecebivel {
    
    protected int id;
    protected String descricao_item;
    protected float valor;
    protected String data;
    protected Categoria categoria;
    protected Connection conexao;

    public HistoricoDespesaRecebivel(Connection conexao) {
        this.conexao = conexao;
    }
    
    public HistoricoDespesaRecebivel(int id, String descricao_item, float valor, String data,Categoria categoria) {
        this.id = id;
        this.descricao_item = descricao_item;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }
    
    public HistoricoDespesaRecebivel(Connection conexao, String descricao_item, float valor, String data, Categoria categoria) {
        this.descricao_item = descricao_item;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.conexao = conexao;
    }
    
    public boolean criar() {
        try {
            String sql = "INSERT INTO `escritorio_real`.`historico_despesa_recebivel` (`descricao_item`, `valor`, `categoria_id`, `data_cadastro`) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, descricao_item);
            pst.setFloat(2, valor);
            pst.setInt(3, categoria.getId());
            pst.setString(4, data);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Informaçao! "+ e.getMessage());
            return false;
        }
    }
    
    public boolean atualizar() {
        try {
            String sql = "UPDATE `escritorio_real`.`historico_despesa_recebivel` SET `descricacao_item` = ?, `valor` = ? `categoria_id` = ? WHERE (`id` = ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, descricao_item);
            pst.setFloat(2, valor);
            pst.setInt(3, categoria.getId());
            pst.setInt(4, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar informaçao!");
            return false;
        }
    }

    public boolean apagar() {
        try {
            String sql = "DELETE FROM `escritorio_real`.`historico_despesa_recebivel` WHERE (`id` = ?);";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao apagar Categoria!");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricacao_item() {
        return descricao_item;
    }

    public void setDescricacao_item(String descricao_item) {
        this.descricao_item = descricao_item;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
}
