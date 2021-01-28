package br.ifsp.projetointegrado.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public abstract class DAO<T> {

    private EntityManagerFactory emf;
    private Class classe;
    

    public DAO() {
        this.emf = Persistence.createEntityManagerFactory("tranoticiaPU");
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        this.classe = ((Class) pt.getActualTypeArguments()[0]);
    }

    protected EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        // insere ou altera
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

//        em.find(class, primaryKey);
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    public List<T> buscar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM " + this.classe.getName() + " e")
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
//     public List pesquisa(Class <T> entity,  String comando) {
//        EntityManager em = getEntityManager();
//        List <T> lista = null;
//        try {
//        Query query = em.createQuery(comando);
//        lista = query.getResultList();
//         return lista;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
    
    

}
