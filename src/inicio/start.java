/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;
import javax.swing.JOptionPane;
import beans.Usuario;
import dao.UsuarioDAO;

/**
 *
 * @author pedro
 */
public class start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // acesso ace = new acesso();
       // ace.efetuarLogin();
       // ace.setLogin("teste");
       // ace.setSenha("teste");
        Usuario usuario = new Usuario();
        usuario.setLogin("Pedro");
        usuario.setSenha("alencar9719");
        usuario.setNivel(1);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
        
        JOptionPane.showMessageDialog(null,"Fim de Programa!");
    }
    
}
