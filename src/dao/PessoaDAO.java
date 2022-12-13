/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Pessoa;
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
public class PessoaDAO {
    private ConexaoSql conexao;
    private Connection conn;
    
    //Vou criar o Construtor da classe. O Construtor
    //é executado automaticamente sempre que um novo
    //objeto é criado.
    // PessoaDAO pessoaDAO = new PessoaDAO();
    public PessoaDAO(){
        this.conexao = new ConexaoSql();
        this.conn = this.conexao.getConexao();
    }
    
    //Query inserir (create)
    public void inserir(Pessoa pessoa){
        String sql = "INSERT INTO pessoa(ra,nome,endereco,cpf,datanasc,telefone,datamatricula,personal) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pessoa.getRa());                     //gravar o RA
            stmt.setString(2, pessoa.getNome());                //gravar o nome
            stmt.setString(3, pessoa.getEndereco());            //gravar o endereço
            stmt.setString(4, pessoa.getCpf());                    //gravar o CPF
            stmt.setString(5, pessoa.getDataNasc());            //gravar a data de cascimento
            stmt.setString(6, pessoa.getTelefone());               //gravar o telefone
            stmt.setString(7, pessoa.getDataMatricula());       //gravar a data de matrícula
            stmt.setInt(8, pessoa.getPersonal());               //gravar se é personal
            stmt.execute();                                     //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao inserir Pessoa: " +e.getMessage());
        }
    }
    
    //Query ler (read)
    //Modo 0 ler os valores do banco de dados pelo RA
    //Modo 1 ler os valores do banco de dados pelo CPF
    public Pessoa getPessoa(String chave, int mode){
        String sql;
        if(mode >= 1)
            sql = "SELECT * FROM pessoa WHERE cpf = ?";
        else
            sql = "SELECT * FROM pessoa WHERE ra = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            if(mode >= 1)
                stmt.setString(1, chave);                       //Obtem o CPF
            else
                stmt.setInt(1, Integer.parseInt(chave));        //Obtem o ra
            
            ResultSet rs = stmt.executeQuery();                 //roda o comando no mysql
            Pessoa pessoa = new Pessoa();
            //Primeiramente, posiciona o ResultSet na primeira posição
            rs.first();
            pessoa.setId(rs.getInt("id"));
            if(mode >= 1)
            {
                pessoa.setRa(rs.getInt("ra"));
                pessoa.setCpf(chave);
            }
            else
            {
                pessoa.setRa(Integer.parseInt(chave));
                pessoa.setCpf(rs.getString("cpf"));
            }
            pessoa.setNome(rs.getString("nome"));
            pessoa.setEndereco(rs.getString("endereco"));
            pessoa.setDataNasc(rs.getString("datanasc"));
            pessoa.setTelefone(rs.getString("telefone"));
            pessoa.setDataMatricula(rs.getString("datamatricula"));
            pessoa.setPersonal(rs.getInt("personal"));
            return pessoa;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            JOptionPane.showMessageDialog(null,"Pessoa não existe!");
            System.out.println("Erro ao buscar Pessoa: " +e.getMessage());
            return null;
        }
    }
    
    //Query editar (update)
    public void editar(Pessoa pessoa){
        String sql = "UPDATE pessoa SET id=?, nome=?, endereco=?, cpf=?, "
                + "datanasc=?, telefone=?, datamatricula=?, personal=? WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pessoa.getId());                 //atualiza o id
            stmt.setString(2, pessoa.getNome());            //atualiza o nome
            stmt.setString(3, pessoa.getEndereco());        //atualiza o endereço
            stmt.setString(4, pessoa.getCpf());                //atualiza o cpf
            stmt.setString(5, pessoa.getDataNasc());        //atualiza a data de nascimento
            stmt.setString(6, pessoa.getTelefone());           //atualiza o telefone
            stmt.setString(7, pessoa.getDataMatricula());   //atualiza a data de matricula
            stmt.setInt(8, pessoa.getPersonal());           //atualiza se é personal
            stmt.setInt(9, pessoa.getRa());                 //seleciona o ra
            stmt.execute();                                 //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao atualizar Pessoa: " +e.getMessage());
        }
    }
    
    //Query excluir (delete)
    public void excluir(int ra){
        String sql = "DELETE FROM pessoa WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ra);                         //exclui a linha que tiver o ra definido
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao excluir Pessoa: " +e.getMessage());
        }
    }
    
    public List<Pessoa> getPessoa()
    {
        String sql = "SELECT * from pessoa";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Pessoa> listaPessoa = new ArrayList();
            //percorre o "rs" e salva as informações dentro de uma var "PEssoa"
            //depois salva esse var dentro da lista
            while(rs.next())
            {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setRa(rs.getInt("ra"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setDataNasc(rs.getString("datanasc"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setDataMatricula(rs.getString("datamatricula"));
                pessoa.setPersonal(rs.getInt("personal"));
                listaPessoa.add(pessoa);
            }
            return listaPessoa;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao listar Pessoa: " +e.getMessage());
            return null;
        }
    }
}
