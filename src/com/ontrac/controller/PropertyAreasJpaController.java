/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontrac.controller;

import com.ontrac.controller.exceptions.NonexistentEntityException;
import com.ontrac.controller.exceptions.PreexistingEntityException;
import com.ontrac.entities.PropertyAreas;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Adedamola
 */
public class PropertyAreasJpaController implements Serializable {

    public PropertyAreasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PropertyAreas propertyAreas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(propertyAreas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPropertyAreas(propertyAreas.getAreaid()) != null) {
                throw new PreexistingEntityException("PropertyAreas " + propertyAreas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PropertyAreas propertyAreas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            propertyAreas = em.merge(propertyAreas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = propertyAreas.getAreaid();
                if (findPropertyAreas(id) == null) {
                    throw new NonexistentEntityException("The propertyAreas with id " + id + " no longer exists.");
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
            PropertyAreas propertyAreas;
            try {
                propertyAreas = em.getReference(PropertyAreas.class, id);
                propertyAreas.getAreaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The propertyAreas with id " + id + " no longer exists.", enfe);
            }
            em.remove(propertyAreas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PropertyAreas> findPropertyAreasEntities() {
        return findPropertyAreasEntities(true, -1, -1);
    }

    public List<PropertyAreas> findPropertyAreasEntities(int maxResults, int firstResult) {
        return findPropertyAreasEntities(false, maxResults, firstResult);
    }

    private List<PropertyAreas> findPropertyAreasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PropertyAreas.class));
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

    public PropertyAreas findPropertyAreas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PropertyAreas.class, id);
        } finally {
            em.close();
        }
    }

    public int getPropertyAreasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PropertyAreas> rt = cq.from(PropertyAreas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
}
