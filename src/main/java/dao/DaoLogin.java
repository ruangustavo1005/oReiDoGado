package dao;

import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Ruan
 */
public class DaoLogin extends Dao<Usuario> {
    
    public DaoLogin() {
        super(Usuario.class);
    }
    
    public int dadosLoginCorretos(Usuario usuario) {
        Query query = entityManager.createQuery("select usuario.id from Usuario usuario where usuario.login = :login and usuario.senha = :senha");
        query.setParameter("login", usuario.getLogin());
        query.setParameter("senha", usuario.getSenha());
        if (query.getResultList().size() == 1) {
            return (int) query.getSingleResult();
        }
        else {
            return 0;
        }
    }
    
}