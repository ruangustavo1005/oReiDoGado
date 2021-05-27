package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ruan
 */
@Entity
public class Usuario extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String senha;

    public Usuario() {
        
    }

    public Usuario(String login, String senha) {
        this.setLogin(login).setSenha(senha);
    }

    public Usuario(int id, String login, String senha) {
        this.setId(id).setLogin(login).setSenha(senha);
    }

    @Override
    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Usuario setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }
    
    @Override
    public String toString() {
        return this.getLogin();
    }
    
}