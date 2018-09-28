/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontrac.controller;

import com.ontrac.controller.exceptions.NonexistentEntityException;
import com.ontrac.controller.exceptions.PreexistingEntityException;
import com.ontrac.entities.PropertyItem;
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
public class PropertyItemJpaController implements Serializable {

    public PropertyItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PropertyItem propertyItem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(propertyItem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPropertyItem(propertyItem.getItemId()) != null) {
                throw new PreexistingEntityException("PropertyItem " + propertyItem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PropertyItem propertyItem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            propertyItem = em.merge(propertyItem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = propertyItem.getItemId();
                if (findPropertyItem(id) == null) {
                    throw new NonexistentEntityException("The propertyItem with id " + id + " no longer exists.");
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
            PropertyItem propertyItem;
            try {
                propertyItem = em.getReference(PropertyItem.class, id);
                propertyItem.getItemId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The propertyItem with id " + id + " no longer exists.", enfe);
            }
            em.remove(propertyItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PropertyItem> findPropertyItemEntities() {
        return findPropertyItemEntities(true, -1, -1);
    }

    public List<PropertyItem> findPropertyItemEntities(int maxResults, int firstResult) {
        return findPropertyItemEntities(false, maxResults, firstResult);
    }

    private List<PropertyItem> findPropertyItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PropertyItem.class));
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

    public PropertyItem findPropertyItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PropertyItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getPropertyItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PropertyItem> rt = cq.from(PropertyItem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
