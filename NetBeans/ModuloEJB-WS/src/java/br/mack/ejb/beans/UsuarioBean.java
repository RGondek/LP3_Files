/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.ejb.beans;
import br.mack.entities.Usuario;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
@Singleton
@LocalBean
public class UsuarioBean {
 private Map<Integer, Usuario> usuarios;
 @PostConstruct
 public void init() {
 usuarios = new HashMap<Integer, Usuario>();
 }
 public int insereUsuario(Usuario u) {
 int id = usuarios.size() + 1;
 u.setId(id);
 usuarios.put(id, u);
 return id;

 }
 public Usuario buscaUsuarioPorId(int id) {
 Usuario u = usuarios.get(id);
 return u;
 }
}