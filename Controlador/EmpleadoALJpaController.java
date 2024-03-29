/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Entity.EmpleadoAL;
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
public class EmpleadoALJpaController implements Serializable {

    public EmpleadoALJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EstacionamientoConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpleadoAL empleadoAL) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleadoAL);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpleadoAL empleadoAL) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleadoAL = em.merge(empleadoAL);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleadoAL.getIdEmpleadoAL();
                if (findEmpleadoAL(id) == null) {
                    throw new NonexistentEntityException("The empleadoAL with id " + id + " no longer exists.");
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
            EmpleadoAL empleadoAL;
            try {
                empleadoAL = em.getReference(EmpleadoAL.class, id);
                empleadoAL.getIdEmpleadoAL();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleadoAL with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleadoAL);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmpleadoAL> findEmpleadoALEntities() {
        return findEmpleadoALEntities(true, -1, -1);
    }

    public List<EmpleadoAL> findEmpleadoALEntities(int maxResults, int firstResult) {
        return findEmpleadoALEntities(false, maxResults, firstResult);
    }

    private List<EmpleadoAL> findEmpleadoALEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpleadoAL.class));
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

    public EmpleadoAL findEmpleadoAL(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpleadoAL.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoALCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpleadoAL> rt = cq.from(EmpleadoAL.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
