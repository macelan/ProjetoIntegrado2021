/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsp.projetointegrado.dao;

import br.com.tranoticia.modelo.Noticia;
import br.com.tranoticia.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author macel
 */
public class UsuarioDAO extends DAO<Usuario> {

     /**
     * METODO LOCALIZA UM USUARIO NO BANCO DE DADOS VERIFICANDO A SENHA E O
     * LOGIN E O RETORNA CASO ENCONTRADO
     *
     * @param login
     * @param senha
     * @return
     */
    public Usuario confirmaUsuario(String login, String senha) {
        // Uusario a ser retornado
       Usuario usuario = null;
        // criar uma conexão com o banco - gerente de entidades
       EntityManager em = getEntityManager();
       TypedQuery<Usuario> query = em.createNamedQuery("Usuario.confirmaUsuario", Usuario.class);
       // passando o nome a ser procurado como parâmetro para a query
       query.setParameter("login", login);
       query.setParameter("senha", senha);
       return query.getSingleResult();
    }
}
