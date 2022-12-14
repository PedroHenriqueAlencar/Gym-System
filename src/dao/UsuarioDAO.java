/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Usuario;
import conexao.ConexaoSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    //Query inserir (create)
    public void inserir(Usuario usuario){
        String sql = "INSERT INTO login(login,senha,nivel,acesso) VALUES"
                + "(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());      //gravar o login
            stmt.setString(2, usuario.getSenha());      //gravar a senha
            stmt.setInt(3, usuario.getNivel());         //gravar o nível de acesso
            stmt.setInt(4, usuario.getAcesso());        //gravar o nível de acesso
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao inserir Usuario: " +e.getMessage());
        }
    }
    
    //Query ler (read)
    //Modo 0 ler os valores do banco de dados pelo RA
    //Modo 1 ler os valores do banco de dados pelo CPF
    public Usuario getUsuario(String login, int mode){
        String sql;
        if(mode >= 1)
            sql = "SELECT * FROM login WHERE login = ?";
        else
            sql = "SELECT * FROM login WHERE ra = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            if(mode >= 1)
                stmt.setString(1, login);                    //Obtem o login
            else
                stmt.setInt(1, Integer.parseInt(login));     //Obtem o RA
            
            ResultSet rs = stmt.executeQuery();              //roda o comando no mysql
            Usuario usuario = new Usuario();
            //Primeiramente, posiciona o ResultSet na primeira posição
            rs.first();
            if(mode >= 1)
            {
                usuario.setRa(rs.getInt("ra"));
                usuario.setLogin(login);
            }
            else
            {
                usuario.setRa(Integer.parseInt(login));
                usuario.setLogin(rs.getString("login"));
            }
            usuario.setSenha(rs.getString("senha"));
            usuario.setNivel(rs.getInt("nivel"));
            usuario.setAcesso(rs.getInt("acesso"));
            return usuario;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar  
            JOptionPane.showMessageDialog(null,"Usuario não existe!");
            System.out.println("Erro ao buscar Usuario: " +e.getMessage());
            return null;
        }
    }
    
    //Query editar (update)
    //Select mode 0 (edita o usuário buscando o RA
    //Select mode 1 (edita o usuário buscando o Login
    public void editar(Usuario usuario, int mode){
        String sql;
        if(mode == 0)
            sql = "UPDATE login SET login=?, senha=?, nivel=?, acesso=? WHERE ra=?";
        else
            sql = "UPDATE login SET login=?, senha=?, nivel=?, acesso=? WHERE login=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());      //atualiza o login
            stmt.setString(2, usuario.getSenha());      //atualiza a senha
            stmt.setInt(3, usuario.getNivel());         //atualiza o nível de acesso
            stmt.setInt(4, usuario.getAcesso());        //atualiza o nível de acesso
            if(mode == 0)
                stmt.setInt(5, usuario.getRa());        //atualiza os campos no RA informado
            else
                stmt.setString(5, usuario.getLogin());     //atualiza os campos no RA informado
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao atualizar Usuario: " +e.getMessage());
        }
    }
    
    //Query excluir (delete)
    public void excluir(int ra){
        String sql = "DELETE FROM login WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ra);                         //exclui a linha que tiver o ra definido
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao excluir Usuario: " +e.getMessage());
        }
    }
    
    public List<Usuario> getUsuario()
    {
        String sql = "SELECT * from login";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Usuario> listaUsuario = new ArrayList();
            //percorre o "rs" e salva as informações dentro de uma var "Usuario"
            //depois salva esse var dentro da lista
            while(rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setRa(rs.getInt("ra"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivel(rs.getInt("nivel"));
                usuario.setAcesso(rs.getInt("acesso"));
                listaUsuario.add(usuario);
            }
            return listaUsuario;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao listar Usuario: " +e.getMessage());
            return null;
        }
    }
}
