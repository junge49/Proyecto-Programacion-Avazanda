/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Entity.EmpleadoG;
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
public class EmpleadoGJpaController implements Serializable {

    public EmpleadoGJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EstacionamientoConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpleadoG empleadoG) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleadoG);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpleadoG empleadoG) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleadoG = em.merge(empleadoG);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleadoG.getIdEmpleadoG();
                if (findEmpleadoG(id) == null) {
                    throw new NonexistentEntityException("The empleadoG with id " + id + " no longer exists.");
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
            EmpleadoG empleadoG;
            try {
                empleadoG = em.getReference(EmpleadoG.class, id);
                empleadoG.getIdEmpleadoG();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleadoG with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleadoG);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmpleadoG> findEmpleadoGEntities() {
        return findEmpleadoGEntities(true, -1, -1);
    }

    public List<EmpleadoG> findEmpleadoGEntities(int maxResults, int firstResult) {
        return findEmpleadoGEntities(false, maxResults, firstResult);
    }

    private List<EmpleadoG> findEmpleadoGEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpleadoG.class));
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

    public EmpleadoG findEmpleadoG(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpleadoG.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoGCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpleadoG> rt = cq.from(EmpleadoG.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
