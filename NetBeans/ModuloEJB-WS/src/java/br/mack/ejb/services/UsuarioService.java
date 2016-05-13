/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.ejb.services;
import br.mack.ejb.beans.UsuarioBean;
import br.mack.entities.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@Stateless
@LocalBean
@WebService
public class UsuarioService {
 @EJB
 UsuarioBean ub;
 @WebMethod(operationName = "findById")
 public Usuario buscaUsuarioPorId(@WebParam(name = "id") final int id) {
 Usuario u = ub.buscaUsuarioPorId(id);

 return u;
 }

 @WebMethod(operationName = "insertUser")
 public void insereUsuario(@WebParam(name = "user") final Usuario u) {
 ub.insereUsuario(u);
 }

}