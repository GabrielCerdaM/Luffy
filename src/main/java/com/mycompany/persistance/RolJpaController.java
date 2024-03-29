/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistance;

import com.mycompany.logic.Rol;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.logic.User;
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
public class RolJpaController implements Serializable {

    public RolJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Luffy_PU");
    }

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        if (rol.getUsers() == null) {
            rol.setUsers(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<User> attachedUsers = new ArrayList<User>();
            for (User usersUserToAttach : rol.getUsers()) {
                usersUserToAttach = em.getReference(usersUserToAttach.getClass(), usersUserToAttach.getId());
                attachedUsers.add(usersUserToAttach);
            }
            rol.setUsers(attachedUsers);
            em.persist(rol);
            for (User usersUser : rol.getUsers()) {
                Rol oldRolOfUsersUser = usersUser.getRol();
                usersUser.setRol(rol);
                usersUser = em.merge(usersUser);
                if (oldRolOfUsersUser != null) {
                    oldRolOfUsersUser.getUsers().remove(usersUser);
                    oldRolOfUsersUser = em.merge(oldRolOfUsersUser);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getId());
            List<User> usersOld = persistentRol.getUsers();
            List<User> usersNew = rol.getUsers();
            List<User> attachedUsersNew = new ArrayList<User>();
            for (User usersNewUserToAttach : usersNew) {
                usersNewUserToAttach = em.getReference(usersNewUserToAttach.getClass(), usersNewUserToAttach.getId());
                attachedUsersNew.add(usersNewUserToAttach);
            }
            usersNew = attachedUsersNew;
            rol.setUsers(usersNew);
            rol = em.merge(rol);
            for (User usersOldUser : usersOld) {
                if (!usersNew.contains(usersOldUser)) {
                    usersOldUser.setRol(null);
                    usersOldUser = em.merge(usersOldUser);
                }
            }
            for (User usersNewUser : usersNew) {
                if (!usersOld.contains(usersNewUser)) {
                    Rol oldRolOfUsersNewUser = usersNewUser.getRol();
                    usersNewUser.setRol(rol);
                    usersNewUser = em.merge(usersNewUser);
                    if (oldRolOfUsersNewUser != null && !oldRolOfUsersNewUser.equals(rol)) {
                        oldRolOfUsersNewUser.getUsers().remove(usersNewUser);
                        oldRolOfUsersNewUser = em.merge(oldRolOfUsersNewUser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rol.getId();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            List<User> users = rol.getUsers();
            for (User usersUser : users) {
                usersUser.setRol(null);
                usersUser = em.merge(usersUser);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
