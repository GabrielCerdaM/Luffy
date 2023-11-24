/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistance;

import com.mycompany.logic.Category;
import com.mycompany.logic.DetailSale;
import com.mycompany.logic.Product;
import com.mycompany.logic.Provider;
import com.mycompany.logic.Rol;
import com.mycompany.logic.Sale;
import com.mycompany.logic.Subcategory;
import com.mycompany.logic.User;
import com.mycompany.persistance.exceptions.NonexistentEntityException;
import com.mycompany.utils.Utils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabriel
 */
public class PersistanceController {


    UserJpaController userJpa = new UserJpaController();
    RolJpaController rolJpa = new RolJpaController();
    ProviderJpaController providerJpa = new ProviderJpaController();
    SaleJpaController saleJpa = new SaleJpaController();
    CategoryJpaController categoryJpa = new CategoryJpaController();
    SubcategoryJpaController subcategoryJpa =  new SubcategoryJpaController();
    ProductJpaController productJpa = new ProductJpaController();
    DetailSaleJpaController detailSaleJpa = new DetailSaleJpaController();

    public List<User> getUsers() {
        return userJpa.findUserEntities();
    }
    
    public List<Rol> getRols() {
        return rolJpa.findRolEntities();
    }

    public boolean createUser(User user) {
        try {
            userJpa.create(user);            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteUser(int userId) {
        try {
            userJpa.destroy(userId);            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistanceController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public User getUser(int userId) {
        return userJpa.findUser(userId);
    }

    public void editUser(User user) throws Exception {
        userJpa.edit(user);
    }

    public List<Category> getCategories() {
        return categoryJpa.findCategoryEntities();
    }

    public void editCategory(Category category) throws Exception {
        categoryJpa.edit(category);
    }

    public void createCategory(Category category) {
        categoryJpa.create(category);
    }

    public Category getCategory(int categoryId) {
        return categoryJpa.findCategory(categoryId);
    }

    public void deleteCategory(int categoryId) {
        try {
            categoryJpa.destroy(categoryId);
        } catch (NonexistentEntityException ex) {
            Utils.showMessage(ex.getMessage(), "Error", PersistanceController.class.getName());
            Logger.getLogger(PersistanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Subcategory> getSubcategories() {
        return subcategoryJpa.findSubcategoryEntities();
    }
    
    public List<Subcategory> getSubcategories(int categoryId) {
        CriteriaBuilder cb = subcategoryJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Subcategory> cq = cb.createQuery(Subcategory.class);
        Root<Subcategory> subcategory = cq.from(Subcategory.class);
        
        cq.select(subcategory).where(cb.equal(subcategory.get("category").get("id"), categoryId));
        return subcategoryJpa.getEntityManager().createQuery(cq).getResultList();
    }    

    public void createSubcategory(Subcategory sc) {
        subcategoryJpa.create(sc);
    }

    public Subcategory getSubcategory(int subcategoryId) {
        return subcategoryJpa.findSubcategory(subcategoryId);
    }

    public void deleteSubcategory(int subcategoryId) throws NonexistentEntityException {
        subcategoryJpa.destroy(subcategoryId);
    }

    public List<Product> getProducts() {
        return productJpa.findProductEntities();
    }

    public List<Provider> getProviders() {
        return providerJpa.findProviderEntities();
    }

    public Product getProduct(int productId) {
        return productJpa.findProduct(productId);
    }

    public void editSubcagetory(Subcategory subcategory) throws Exception {
        subcategoryJpa.edit(subcategory);
    }

    public void editProduct(Product product) throws Exception {
        productJpa.edit(product);
    }

    public void createProduct(Product product) {
        productJpa.create(product);
    }

    public void deleteProduct(int productId) throws NonexistentEntityException {
        productJpa.destroy(productId);
    }

    public List<Sale> getSales() {
        return saleJpa.findSaleEntities();
    }

    public List<DetailSale> getDetailSale(int saleId) {
        CriteriaBuilder cb = subcategoryJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<DetailSale> cq = cb.createQuery(DetailSale.class);
        Root<DetailSale> detailSale = cq.from(DetailSale.class);
        
        cq.select(detailSale).where(cb.equal(detailSale.get("sale").get("id"), saleId));
        return subcategoryJpa.getEntityManager().createQuery(cq).getResultList();

    }

    public List<DetailSale> getAllDetailSale() {
        return detailSaleJpa.findDetailSaleEntities();
    }

}
