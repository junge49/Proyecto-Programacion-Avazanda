/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Entity.EspaciosEst;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author joel_
 */
public class EspaciosEstJpaController implements Serializable {

    public EspaciosEstJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EstacionamientoConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EspaciosEst espaciosEst) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(espaciosEst);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EspaciosEst espaciosEst) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            espaciosEst = em.merge(espaciosEst);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = espaciosEst.getIdEspaciosEst();
                if (findEspaciosEst(id) == null) {
                    throw new NonexistentEntityException("The espaciosEst with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EspaciosEst espaciosEst;
            try {
                espaciosEst = em.getReference(EspaciosEst.class, id);
                espaciosEst.getIdEspaciosEst();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The espaciosEst with id " + id + " no longer exists.", enfe);
            }
            em.remove(espaciosEst);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EspaciosEst> findEspaciosEstEntities() {
        return findEspaciosEstEntities(true, -1, -1);
    }

    public List<EspaciosEst> findEspaciosEstEntities(int maxResults, int firstResult) {
        return findEspaciosEstEntities(false, maxResults, firstResult);
    }

    private List<EspaciosEst> findEspaciosEstEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EspaciosEst.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EspaciosEst findEspaciosEst(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EspaciosEst.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspaciosEstCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EspaciosEst> rt = cq.from(EspaciosEst.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
