/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import beans.Usuario;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author pedro
 */
public class Acesso {
    
    private String login;
    private String senha;
    private boolean logado;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    /*--Digitar as Credenciais de Login--*/
    public void efetuarLogin()
    {
        this.login = JOptionPane.showInputDialog(null,"Digite seu usuário de acesso:");
        this.senha = JOptionPane.showInputDialog(null,"Digite sua senha de acesso:");
        if(validarAcesso(login, senha)){
            this.logado = true;
            JOptionPane.showMessageDialog(null,"Acesso validado com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Não foi possível validar acesso, revise seus dados!");
        }
    }
    
    /*--Validar Login--*/
    public boolean validarAcesso(String login, String senha)
    {
        JOptionPane.showMessageDialog(null,"Aguarde... validando acesso!");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.getUsuario(login);
        String LogLogin = usuario.getLogin();
        String LogSenha = usuario.getSenha();
        
        if(usuario == null)
            JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos! Tente novamente!");
        
        return !(!LogLogin.equals(login) || !LogSenha.equals(senha));
    }
    
    /*--Deslogar--*/
    public void efetuarLogoff()
    {
        this.login = null;
        this.senha = null;
        this.logado = false;
    }
}