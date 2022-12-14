/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Metricas;
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
public class MetricasDAO {
    private ConexaoSql conexao;
    private Connection conn;
    
    //Vou criar o Construtor da classe. O Construtor
    //é executado automaticamente sempre que um novo
    //objeto é criado.
    // MetricasDAO metricasDAO = new MetricasDAO();
    public MetricasDAO(){
        this.conexao = new ConexaoSql();
        this.conn = this.conexao.getConexao();
    }
    
    //Query inserir (create)
    public void inserir(Metricas metricas){
        String sql = "INSERT INTO metricas(ra,altura,peso,abdomem,quadril,peitoral,braco,"
                + "perna,datacadastro,situacaocorporal) VALUES"
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
            System.out.println("Erro ao inserir Metricas: " +e.getMessage());
        }
    }
    
    //Query ler (read)
    public Metricas getMetricas(int ra){
        String sql = "SELECT * FROM metricas WHERE ra = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ra);                              //Obtem o ra
            ResultSet rs = stmt.executeQuery();              //roda o comando no mysql
            Metricas metricas = new Metricas();
            //Primeiramente, posiciona o ResultSet na primeira posição
            rs.first();
            metricas.setRa(ra);
            metricas.setAltura(rs.getDouble("altura"));
            metricas.setPeso(rs.getDouble("peso"));
            metricas.setAbdomem(rs.getDouble("abdomem"));
            metricas.setQuadril(rs.getDouble("quadril"));
            metricas.setPeitoral(rs.getDouble("peitoral"));
            metricas.setBraco(rs.getDouble("braco"));
            metricas.setPerna(rs.getDouble("perna"));
            metricas.setDataCadastro(rs.getString("dataCadastro"));
            metricas.setSituacaoCorporal(rs.getString("situacaocorporal"));
            return metricas;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            JOptionPane.showMessageDialog(null,"Metricas não existe!");
            System.out.println("Erro ao buscar Metricas: " +e.getMessage());
            return null;
        }
    }
    
    //Query editar (update)
    public void editar(Metricas metricas){
        String sql = "UPDATE metricas SET altura=?, peso=?, abdomem=?, quadril=?, "
                + "peitoral=?, braco=?, perna=?, datacadastro=?, situacaocorporal=? WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setDouble(1, metricas.getAltura());                //atualiza a altura
            stmt.setDouble(2, metricas.getPeso());                  //atualiza o peso
            stmt.setDouble(3, metricas.getAbdomem());               //atualiza o abdomem
            stmt.setDouble(4, metricas.getQuadril());               //atualiza o quadril
            stmt.setDouble(5, metricas.getPeitoral());              //atualiza o peitoral
            stmt.setDouble(6, metricas.getBraco());                 //atualiza o braco
            stmt.setDouble(7, metricas.getPerna());                 //atualiza a perna
            stmt.setString(8, metricas.getDataCadastro());          //atualiza a data de cadastro
            stmt.setString(9, metricas.getSituacaoCorporal());      //atualiza a situação corporal
            stmt.setInt(10, metricas.getRa());                      //seleciona o ra
            stmt.execute();                                         //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao atualizar Metricas: " +e.getMessage());
        }
    }
    
    //Query excluir (delete)
    public void excluir(int ra){
        String sql = "DELETE FROM metricas WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ra);                         //exclui a linha que tiver o ra definido
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao excluir Metricas: " +e.getMessage());
        }
    }
    
    public List<Metricas> getMetricas()
    {
        String sql = "SELECT * from metricas";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Metricas> listaMetricas = new ArrayList();
            //percorre o "rs" e salva as informações dentro de uma var "PEssoa"
            //depois salva esse var dentro da lista
            while(rs.next())
            {
                Metricas metricas = new Metricas();
                metricas.setRa(rs.getInt("ra"));
                metricas.setAltura(rs.getDouble("altura"));
                metricas.setPeso(rs.getDouble("peso"));
                metricas.setAbdomem(rs.getDouble("abdomem"));
                metricas.setQuadril(rs.getDouble("quadril"));
                metricas.setPeitoral(rs.getDouble("peitoral"));
                metricas.setBraco(rs.getDouble("braco"));
                metricas.setPerna(rs.getDouble("perna"));
                metricas.setDataCadastro(rs.getString("dataCadastro"));
                metricas.setSituacaoCorporal(rs.getString("situacaocorporal"));
                listaMetricas.add(metricas);
            }
            return listaMetricas;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao listar Metricas: " +e.getMessage());
            return null;
        }
    }
}