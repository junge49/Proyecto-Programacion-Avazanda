/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entity.Gerente;
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
public class GerenteJpaController implements Serializable {

    public GerenteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EstacionamientoConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gerente gerente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gerente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGerente(gerente.getIdGerente()) != null) {
                throw new PreexistingEntityException("Gerente " + gerente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gerente gerente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gerente = em.merge(gerente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gerente.getIdGerente();
                if (findGerente(id) == null) {
                    throw new NonexistentEntityException("The gerente with id " + id + " no longer exists.");
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
            Gerente gerente;
            try {
                gerente = em.getReference(Gerente.class, id);
                gerente.getIdGerente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gerente with id " + id + " no longer exists.", enfe);
            }
            em.remove(gerente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gerente> findGerenteEntities() {
        return findGerenteEntities(true, -1, -1);
    }

    public List<Gerente> findGerenteEntities(int maxResults, int firstResult) {
        return findGerenteEntities(false, maxResults, firstResult);
    }

    private List<Gerente> findGerenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gerente.class));
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

    public Gerente findGerente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gerente.class, id);
        } finally {
            em.close();
        }
    }

    public int getGerenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gerente> rt = cq.from(Gerente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
