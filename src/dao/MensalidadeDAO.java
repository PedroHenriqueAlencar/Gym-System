/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;//Objeto de Acesso aos Dados

import beans.Mensalidade;
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
public class MensalidadeDAO {
    private ConexaoSql conexao;
    private Connection conn;
    
    //Vou criar o Construtor da classe. O Construtor
    //é executado automaticamente sempre que um novo
    //objeto é criado.
    // MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
    public MensalidadeDAO(){
        this.conexao = new ConexaoSql();
        this.conn = this.conexao.getConexao();
    }
    
    //Query inserir (create)
    public void inserir(Mensalidade mensalidade){
        String sql = "INSERT INTO mensalidade(ra,mes,valor,status,datapag,formapag) VALUES"
                + "(?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, mensalidade.getRa());                        //gravar o RA
            stmt.setString(2, mensalidade.getMes());                    //gravar o mes
            stmt.setDouble(3, mensalidade.getValor());                  //gravar o mes
            stmt.setString(4, mensalidade.getStatus());                 //gravar o status de pagamento
            stmt.setString(5, mensalidade.getDataPag());                //gravar a data de pagamento
            stmt.setString(6, mensalidade.getFormaPag());               //gravar a forma de pagamento
            stmt.execute();                                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao inserir Mensalidade: " +e.getMessage());
        }
    }
    
    //Query ler (read)
    public Mensalidade getMensalidade(String chave){
        String sql = "SELECT * FROM mensalidade WHERE ra = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(chave));                              //Obtem o ra
            ResultSet rs = stmt.executeQuery();              //roda o comando no mysql
            Mensalidade mensalidade = new Mensalidade();
            //Primeiramente, posiciona o ResultSet na primeira posição
            rs.first();
            mensalidade.setRa(Integer.parseInt(chave));
            mensalidade.setMes(rs.getString("mes"));
            mensalidade.setValor(rs.getDouble("valor"));
            mensalidade.setStatus(rs.getString("status"));
            mensalidade.setDataPag(rs.getString("datapag"));
            mensalidade.setFormaPag(rs.getString("formapag"));
            return mensalidade;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            JOptionPane.showMessageDialog(null,"Mensalidade não existe!");
            System.out.println("Erro ao buscar Mensalidade: " +e.getMessage());
            return null;
        }
    }
    
    //Query editar (update)
    public void editar(Mensalidade mensalidade){
        String sql = "UPDATE mensalidade SET mes=?, valor=?, status=?, datapag=?, "
                + "formapag=? WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, mensalidade.getMes());                    //atualiza o mes
            stmt.setDouble(2, mensalidade.getValor());                  //atualiza o valor
            stmt.setString(3, mensalidade.getStatus());                 //atualiza o status do pagamento
            stmt.setString(4, mensalidade.getDataPag());                //atualiza a data de pagamento
            stmt.setString(5, mensalidade.getFormaPag());               //atualiza a forma de pagamento
            stmt.setInt(6, mensalidade.getRa());                        //seleciona o ra
            stmt.execute();                                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao atualizar Mensalidade: " +e.getMessage());
        }
    }
    
    //Query excluir (delete)
    public void excluir(int ra){
        String sql = "DELETE FROM mensalidade WHERE ra=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, ra);                         //exclui a linha que tiver o ra definido
            stmt.execute();                             //roda o comando no mysql
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao excluir Mensalidade: " +e.getMessage());
        }
    }
    
    public List<Mensalidade> getMensalidade()
    {
        String sql = "SELECT * from mensalidade";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Mensalidade> listaMensalidade = new ArrayList();
            //percorre o "rs" e salva as informações dentro de uma var "PEssoa"
            //depois salva esse var dentro da lista
            while(rs.next())
            {
                Mensalidade mensalidade = new Mensalidade();
                mensalidade.setRa(rs.getInt("ra"));
                mensalidade.setMes(rs.getString("mes"));
                mensalidade.setValor(rs.getDouble("valor"));
                mensalidade.setStatus(rs.getString("status"));
                mensalidade.setDataPag(rs.getString("datapag"));
                mensalidade.setFormaPag(rs.getString("formapag"));
                listaMensalidade.add(mensalidade);
            }
            return listaMensalidade;
        }
        catch(SQLException e){
            //se deu erro na hora de conectar
            System.out.println("Erro ao listar Mensalidade: " +e.getMessage());
            return null;
        }
    }
}