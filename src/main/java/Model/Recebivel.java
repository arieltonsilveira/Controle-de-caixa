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
public class Recebivel extends HistoricoDespesaRecebivel{

    public Recebivel(Connection conexao) {
        super(conexao);
    }    

    public Recebivel(int id, String descricao_item, float valor, String data, Categoria categoria) {
        super(id, descricao_item, valor, data, categoria);
    }
    
    public Recebivel(Connection conexao, String descricao_item, float valor, String data,Categoria categoria) {
        super(conexao, descricao_item, valor, data, categoria);
    }
    
    public ArrayList<Recebivel> pesquisarPorCategoria(String data_inicio, String data_final, String nome) {
        try {
            String sql = "SELECT * FROM escritorio_real.historico_despesa_recebivel as rec inner join categoria as cat on cat.id = rec.categoria_id where cat.tipo = 'RECEBIVEL' and rec.data_cadastro between ? and ? and descricao_item like ?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, data_inicio);
            pst.setString(2, data_final);
            pst.setString(3, "%" + nome + "%");
            ResultSet rs = pst.executeQuery();
            
            ArrayList<Recebivel> recebiveis = new ArrayList<>();
            
            while (rs.next()) {
                recebiveis.add(new Recebivel(rs.getInt("rec.id"), rs.getString("descricao_item"), rs.getFloat("valor"),
                        rs.getString("data_cadastro"), new Categoria(rs.getInt("cat.id"), rs.getString("descricao_item"), "RECEBIVEL"))
                );
            }
            return recebiveis;
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar categoria por categoria!" + e.getMessage());
            return new ArrayList<>();
        }
    }
}
