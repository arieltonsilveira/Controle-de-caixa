/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class Mysql {
    public static Connection conector(){
        Connection conexao = null;
        //chamar o driver
        String driver = "com.mysql.jdbc.Driver";
        //Armazenando infos do banco
        String url = "jdbc:mysql://localhost:3306/escritorio_real";
        String user = "root";
        String password = "";
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escritorio_real?useSSL=false","root","");
        //Estabelecer a conexao com o DB
        try {
            Class.forName(driver);
            // conexao = DriverManager.getConnection(url, user, password);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/escritorio_real?useSSL=false","root","");
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, conexao);
            return null;
        }
    }
}
