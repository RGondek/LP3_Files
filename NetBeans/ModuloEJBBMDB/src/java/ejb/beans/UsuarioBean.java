/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.beans;

import ejb.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class UsuarioBean {

    @PersistenceContext(unitName = "DerbyPU")
    private EntityManager em;

    public void save(Usuario u) {
        em.persist(u);
    }

    public List<Usuario> list() {
        Query query = em.createQuery("FROM Usuario u");
        List<Usuario> list = query.getResultList();
        return list;
    }
}
