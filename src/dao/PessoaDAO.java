/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Pessoa;
import conexao.ConexaoSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    //Query inserir
    public void inserir(Pessoa pessoa){
        String sql = "INSERT INTO pessoa(ra,nome,endereco,cpf,datanasc,telefone,datamatricula,personal) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pessoa.getRa());                     //gravar o RA
            stmt.setString(2, pessoa.getNome());                //gravar o nome
            stmt.setString(3, pessoa.getEndereco());            //gravar o endereço
            stmt.setInt(4, pessoa.getCpf());                    //gravar o CPF
            stmt.setString(5, pessoa.getDataNasc());            //gravar a data de cascimento
            stmt.setInt(6, pessoa.getTelefone());               //gravar o telefone
            stmt.setString(7, pessoa.getDataMatricula());       //gravar a data de matrícula
            stmt.setInt(8, pessoa.getPersonal());               //gravar se é personal
            stmt.execute();                                     //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao inserir Pessoa: " +e.getMessage());
        }
    }
}
