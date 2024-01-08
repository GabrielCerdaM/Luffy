/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistance;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.logic.Client;
import com.mycompany.logic.DetailSale;
import com.mycompany.logic.Sale;
import com.mycompany.persistance.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class SaleJpaController implements Serializable {

    public SaleJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Luffy_PU");
    }

    public SaleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sale sale) {
        if (sale.getDetailSale() == null) {
            sale.setDetailSale(new ArrayList<DetailSale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client client = sale.getClient();
            if (client != null) {
                client = em.getReference(client.getClass(), client.getId());
                sale.setClient(client);
            }
            List<DetailSale> attachedDetailSale = new ArrayList<DetailSale>();
            for (DetailSale detailSaleDetailSaleToAttach : sale.getDetailSale()) {
                detailSaleDetailSaleToAttach = em.getReference(detailSaleDetailSaleToAttach.getClass(), detailSaleDetailSaleToAttach.getId());
                attachedDetailSale.add(detailSaleDetailSaleToAttach);
            }
            sale.setDetailSale(attachedDetailSale);
            em.persist(sale);
            if (client != null) {
                client.getSale().add(sale);
                client = em.merge(client);
            }
            for (DetailSale detailSaleDetailSale : sale.getDetailSale()) {
                Sale oldSaleOfDetailSaleDetailSale = detailSaleDetailSale.getSale();
                detailSaleDetailSale.setSale(sale);
                detailSaleDetailSale = em.merge(detailSaleDetailSale);
                if (oldSaleOfDetailSaleDetailSale != null) {
                    oldSaleOfDetailSaleDetailSale.getDetailSale().remove(detailSaleDetailSale);
                    oldSaleOfDetailSaleDetailSale = em.merge(oldSaleOfDetailSaleDetailSale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sale sale) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sale persistentSale = em.find(Sale.class, sale.getId());
            Client clientOld = persistentSale.getClient();
            Client clientNew = sale.getClient();
            List<DetailSale> detailSaleOld = persistentSale.getDetailSale();
            List<DetailSale> detailSaleNew = sale.getDetailSale();
            if (clientNew != null) {
                clientNew = em.getReference(clientNew.getClass(), clientNew.getId());
                sale.setClient(clientNew);
            }
            List<DetailSale> attachedDetailSaleNew = new ArrayList<DetailSale>();
            for (DetailSale detailSaleNewDetailSaleToAttach : detailSaleNew) {
                detailSaleNewDetailSaleToAttach = em.getReference(detailSaleNewDetailSaleToAttach.getClass(), detailSaleNewDetailSaleToAttach.getId());
                attachedDetailSaleNew.add(detailSaleNewDetailSaleToAttach);
            }
            detailSaleNew = attachedDetailSaleNew;
            sale.setDetailSale(detailSaleNew);
            sale = em.merge(sale);
            if (clientOld != null && !clientOld.equals(clientNew)) {
                clientOld.getSale().remove(sale);
                clientOld = em.merge(clientOld);
            }
            if (clientNew != null && !clientNew.equals(clientOld)) {
                clientNew.getSale().add(sale);
                clientNew = em.merge(clientNew);
            }
            for (DetailSale detailSaleOldDetailSale : detailSaleOld) {
                if (!detailSaleNew.contains(detailSaleOldDetailSale)) {
                    detailSaleOldDetailSale.setSale(null);
                    detailSaleOldDetailSale = em.merge(detailSaleOldDetailSale);
                }
            }
            for (DetailSale detailSaleNewDetailSale : detailSaleNew) {
                if (!detailSaleOld.contains(detailSaleNewDetailSale)) {
                    Sale oldSaleOfDetailSaleNewDetailSale = detailSaleNewDetailSale.getSale();
                    detailSaleNewDetailSale.setSale(sale);
                    detailSaleNewDetailSale = em.merge(detailSaleNewDetailSale);
                    if (oldSaleOfDetailSaleNewDetailSale != null && !oldSaleOfDetailSaleNewDetailSale.equals(sale)) {
                        oldSaleOfDetailSaleNewDetailSale.getDetailSale().remove(detailSaleNewDetailSale);
                        oldSaleOfDetailSaleNewDetailSale = em.merge(oldSaleOfDetailSaleNewDetailSale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sale.getId();
                if (findSale(id) == null) {
                    throw new NonexistentEntityException("The sale with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sale sale;
            try {
                sale = em.getReference(Sale.class, id);
                sale.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sale with id " + id + " no longer exists.", enfe);
            }
            Client client = sale.getClient();
            if (client != null) {
                client.getSale().remove(sale);
                client = em.merge(client);
            }
            List<DetailSale> detailSale = sale.getDetailSale();
            for (DetailSale detailSaleDetailSale : detailSale) {
                detailSaleDetailSale.setSale(null);
                detailSaleDetailSale = em.merge(detailSaleDetailSale);
            }
            em.remove(sale);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sale> findSaleEntities() {
        return findSaleEntities(true, -1, -1);
    }

    public List<Sale> findSaleEntities(int maxResults, int firstResult) {
        return findSaleEntities(false, maxResults, firstResult);
    }

    private List<Sale> findSaleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sale.class));
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

    public Sale findSale(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sale.class, id);
        } finally {
            em.close();
        }
    }

    public int getSaleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sale> rt = cq.from(Sale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
