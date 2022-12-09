/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;
import javax.swing.JOptionPane;
import beans.Usuario;
import conexao.Acesso;
import dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author pedro
 */
public class start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TESTAR A VALIDAÇÂO DE LOGIN
        //Acesso acesso = new Acesso();
        //acesso.efetuarLogin();
        
        //TESTAR O CADASTRO DE CONTA DO FUNCIONARIO
        //Usuario usuario = new Usuario();
        //usuario.setLogin("ADMINISTRADOR");
        //usuario.setSenha("ADMINISTRAODR");
        //usuario.setNivel(1);
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //usuarioDAO.inserir(usuario);
        
        //TESTAR A ATUALIZAÇÃO DE DADOS DA CONTA DO FUNCIONARIO
        //String login = JOptionPane.showInputDialog(null,"Digite o login da conta que deseja alterar os dados:");
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //Usuario usuario = usuarioDAO.getUsuario(login);
        //usuario.setSenha("Manuel");
        //usuarioDAO.editar(usuario,1);
        
        //TESTAR A EXCLUSÃO DE DADOS DO LOGIN DO FUNCIONARIO
        //int ra = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o RA da conta que deseja alterar os dados:"));
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //usuarioDAO.excluir(1000001);
        
        //TESTAR A LISTAGEM DE DADOS DA TABELA LOGIN
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //List<Usuario> listaUsuario = usuarioDAO.getUsuario();
        //for(Usuario u : listaUsuario)
        //{
        //    JOptionPane.showMessageDialog(null,"RA:" + u.getRa());
        //    JOptionPane.showMessageDialog(null,"Login:" + u.getLogin());
        //    JOptionPane.showMessageDialog(null,"Senha:" + u.getSenha());
        //    JOptionPane.showMessageDialog(null,"Nivel:" + u.getNivel());
        //}
        
        JOptionPane.showMessageDialog(null,"Fim de Programa!");
    }
    
}
