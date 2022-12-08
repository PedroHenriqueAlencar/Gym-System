/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Metricas;
import conexao.ConexaoSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class MetricasDAO {
    private ConexaoSql conexao;
    private Connection conn;
    
    //Vou criar o Construtor da classe. O Construtor
    //é executado automaticamente sempre que um novo
    //objeto é criado.
    // PessoaDAO pessoaDAO = new PessoaDAO();
    public MetricasDAO(){
        this.conexao = new ConexaoSql();
        this.conn = this.conexao.getConexao();
    }
    
    //Query inserir
    public void inserir(Metricas metricas){
        String sql = "INSERT INTO metricas(ra,altura,peso,abdomem,quadril,peitoral,braco,perna,datacadastro,situacaocorporal) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, metricas.getRa());                       //gravar o RA
            stmt.setDouble(2, metricas.getAltura());                //gravar a altura
            stmt.setDouble(3, metricas.getPeso());                  //gravar o peso
            stmt.setDouble(4, metricas.getAbdomem());               //gravar o abdomem
            stmt.setDouble(5, metricas.getQuadril());               //gravar o quadril
            stmt.setDouble(6, metricas.getPeitoral());              //gravar o peitoral
            stmt.setDouble(7, metricas.getBraco());                 //gravar o braço
            stmt.setDouble(8, metricas.getPerna());                 //gravar a perna
            stmt.setString(9, metricas.getDataCadastro());          //gravar a data de cadastro
            stmt.setString(10, metricas.getSituacaoCorporal());     //gravar a situação corporal
            stmt.execute();                                         //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao inserir Pessoa: " +e.getMessage());
        }
    }
}