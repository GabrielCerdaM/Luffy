/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistance;

import com.mycompany.logic.Client;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class ClientJpaController implements Serializable {

    public ClientJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Luffy_PU");
    }

    public ClientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Client client) {
        if (client.getSale() == null) {
            client.setSale(new ArrayList<Sale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Sale> attachedSale = new ArrayList<Sale>();
            for (Sale saleSaleToAttach : client.getSale()) {
                saleSaleToAttach = em.getReference(saleSaleToAttach.getClass(), saleSaleToAttach.getId());
                attachedSale.add(saleSaleToAttach);
            }
            client.setSale(attachedSale);
            em.persist(client);
            for (Sale saleSale : client.getSale()) {
                Client oldClientOfSaleSale = saleSale.getClient();
                saleSale.setClient(client);
                saleSale = em.merge(saleSale);
                if (oldClientOfSaleSale != null) {
                    oldClientOfSaleSale.getSale().remove(saleSale);
                    oldClientOfSaleSale = em.merge(oldClientOfSaleSale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Client client) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client persistentClient = em.find(Client.class, client.getId());
            List<Sale> saleOld = persistentClient.getSale();
            List<Sale> saleNew = client.getSale();
            List<Sale> attachedSaleNew = new ArrayList<Sale>();
            for (Sale saleNewSaleToAttach : saleNew) {
                saleNewSaleToAttach = em.getReference(saleNewSaleToAttach.getClass(), saleNewSaleToAttach.getId());
                attachedSaleNew.add(saleNewSaleToAttach);
            }
            saleNew = attachedSaleNew;
            client.setSale(saleNew);
            client = em.merge(client);
            for (Sale saleOldSale : saleOld) {
                if (!saleNew.contains(saleOldSale)) {
                    saleOldSale.setClient(null);
                    saleOldSale = em.merge(saleOldSale);
                }
            }
            for (Sale saleNewSale : saleNew) {
                if (!saleOld.contains(saleNewSale)) {
                    Client oldClientOfSaleNewSale = saleNewSale.getClient();
                    saleNewSale.setClient(client);
                    saleNewSale = em.merge(saleNewSale);
                    if (oldClientOfSaleNewSale != null && !oldClientOfSaleNewSale.equals(client)) {
                        oldClientOfSaleNewSale.getSale().remove(saleNewSale);
                        oldClientOfSaleNewSale = em.merge(oldClientOfSaleNewSale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = client.getId();
                if (findClient(id) == null) {
                    throw new NonexistentEntityException("The client with id " + id + " no longer exists.");
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
            Client client;
            try {
                client = em.getReference(Client.class, id);
                client.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The client with id " + id + " no longer exists.", enfe);
            }
            List<Sale> sale = client.getSale();
            for (Sale saleSale : sale) {
                saleSale.setClient(null);
                saleSale = em.merge(saleSale);
            }
            em.remove(client);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Client> findClientEntities() {
        return findClientEntities(true, -1, -1);
    }

    public List<Client> findClientEntities(int maxResults, int firstResult) {
        return findClientEntities(false, maxResults, firstResult);
    }

    private List<Client> findClientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Client.class));
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

    public Client findClient(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Client.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Client> rt = cq.from(Client.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
