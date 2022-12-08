/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Usuario;
import conexao.ConexaoSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class UsuarioDAO {
    private ConexaoSql conexao;
    private Connection conn;
    
    //Vou criar o Construtor da classe. O Construtor
    //é executado automaticamente sempre que um novo
    //objeto é criado.
    // UsuarioDAO usuarioDAO = new UsuarioDAO();
    public UsuarioDAO(){
        this.conexao = new ConexaoSql();
        this.conn = this.conexao.getConexao();
    }
    
    //Query inserir
    public void inserir(Usuario usuario){
        String sql = "INSERT INTO login(login,senha,nivel) VALUES"
                + "(?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());      //gravar o login
            stmt.setString(2, usuario.getSenha());      //gravar a senha
            stmt.setInt(3, usuario.getNivel());         //gravar o nível de acesso
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao inserir Usuário: " +e.getMessage());
        }
    }
}
