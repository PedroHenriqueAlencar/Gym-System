/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class ConexaoSql {
    
    public Connection getConexao()
    {
       try {
           //tentar estabelecer a conexão
           Connection conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/ab3?serverTimezone=UTC",    //linha de conexão
                   "root",                                                  //usuário do mysql
                   ""                                                       //senha do mysql
           );
           Statement stmt = conn.createStatement();
           return conn;
       } catch (SQLException e)
       {
           //se deu erro na hora de conectar
           System.out.println("Erro ao conectar com banco de dados!" +e.getMessage());
           return null;
       }
    }
}
