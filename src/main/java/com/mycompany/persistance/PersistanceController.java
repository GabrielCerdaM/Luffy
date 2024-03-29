/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistance;

import com.mycompany.logic.Category;
import com.mycompany.logic.Client;
import com.mycompany.logic.DetailSale;
import com.mycompany.logic.Document;
import com.mycompany.logic.Payment;
import com.mycompany.logic.Product;
import com.mycompany.logic.Provider;
import com.mycompany.logic.Rol;
import com.mycompany.logic.Sale;
import com.mycompany.logic.Subcategory;
import com.mycompany.logic.User;
import com.mycompany.persistance.exceptions.NonexistentEntityException;
import com.mycompany.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabriel
 */
public class PersistanceController {

    UserJpaController userJpa;
    RolJpaController rolJpa;
    ProviderJpaController providerJpa;
    SaleJpaController saleJpa;
    CategoryJpaController categoryJpa;
    SubcategoryJpaController subcategoryJpa;
    ProductJpaController productJpa;
    DetailSaleJpaController detailSaleJpa;
    ClientJpaController clientJpa;
    PaymentJpaController paymentJpa;
    DocumentJpaController documentJpa;

    public PersistanceController() {
        try {
            userJpa = new UserJpaController();
            rolJpa = new RolJpaController();
            providerJpa = new ProviderJpaController();
            saleJpa = new SaleJpaController();
            categoryJpa = new CategoryJpaController();
            subcategoryJpa = new SubcategoryJpaController();
            productJpa = new ProductJpaController();
            detailSaleJpa = new DetailSaleJpaController();
            clientJpa = new ClientJpaController();
            paymentJpa = new PaymentJpaController();
            documentJpa = new DocumentJpaController();
        } catch (Exception e) {
            Utils.showMessage(e.getMessage(), "Error", "Error al conectar la base de datos");
        }
    }

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
            Logger.getLogger(PersistanceController.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Product> getProductBy(int subcategoryId) {
        CriteriaBuilder cb = productJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        cq.select(product).where(cb.equal(product.get("subcategory").get("id"), subcategoryId));
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

    public void createSale(Sale sale) {
        saleJpa.create(sale);
    }

    public void createProvider(Provider p) {
        providerJpa.create(p);
    }

    public List<Product> getFilterProducts(String search, String categoryName, String subcategoryName, String providerName) {
        System.out.println("" + categoryName);
        System.out.println("" + subcategoryName);
        System.out.println("" + providerName);

        CriteriaBuilder cb = productJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (search != null && !search.isEmpty()) {
            Predicate predicateOr = cb.or(
                    cb.equal(product.get("name"), search)
            );
            predicates.add(predicateOr);
        }

        // Filtrar por subcategoría
        if (subcategoryName != null && !subcategoryName.isEmpty()) {
            System.out.println("subcategory filter");
            Join<Product, Subcategory> subcategoryJoin = product.join("subcategory");
            predicates.add(cb.equal(subcategoryJoin.get("name"), subcategoryName));
        } else {
            // Filtrar por categoría
            System.out.println("!null " + categoryName != null);
            System.out.println("!isEmpty " + !categoryName.isEmpty());
            if (categoryName != null && !categoryName.isEmpty()) {
                System.out.println("category filter");
                Join<Product, Subcategory> subcategoryJoin = product.join("subcategory");
                Join<Subcategory, Category> categoryJoin = subcategoryJoin.join("category");
                predicates.add(cb.equal(categoryJoin.get("name"), categoryName));
            }

        }

        // Filtrar por proveedor
        if (providerName != null && !providerName.isEmpty()) {
            System.out.println("provider filter");
            Join<Product, Provider> providerJoin = product.join("provider");
            predicates.add(cb.equal(providerJoin.get("name"), providerName));
        }
        // el error esta aca
//        Predicate[] predArray = new Predicate[predicates.size()];
//        predicates.toArray(predArray);
        System.out.println("predicates" + predicates.toString());
        cq.where(predicates.toArray(new Predicate[0]));
//        cq.where(predArray);

        return productJpa.getEntityManager().createQuery(cq).getResultList();
    }

    public List<Client> getClients() {
        return clientJpa.findClientEntities();
    }

    public List<Client> getClients(String search) {
        System.out.println("search: " + search);
        CriteriaBuilder cb = clientJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> client = cq.from(Client.class);
        Predicate p = cb.or(
                cb.like(client.get("address"), "%" + search + "%"),
                cb.like(client.get("cementery"), "%" + search + "%"),
                cb.like(client.get("name"), "%" + search + "%"),
                cb.like(client.get("nameDeceased"), "%" + search + "%"),
                cb.like(client.get("phone"), "%" + search + "%"),
                cb.like(client.get("rut"), "%" + search + "%"),
                cb.like(client.get("rutDeceased"), "%" + search + "%"),
                cb.like(client.get("wakeAddress"), "%" + search + "%")
        );
        cq.where(p);
        return clientJpa.getEntityManager().createQuery(cq).getResultList();
    }

    public Client getClientById(int clientId) {
        return clientJpa.findClient(clientId);
    }

    public void createClient(Client c) {
        clientJpa.create(c);
    }

    public List<Payment> getPayments() {
        return paymentJpa.findPaymentEntities();
    }

    public List<Payment> getPayments(int clientId) {
        CriteriaBuilder cb = paymentJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
        Root<Payment> payment = cq.from(Payment.class);
        Predicate p = cb.equal(payment.get("client").get("id"), clientId);
        cq.where(p);
        return paymentJpa.getEntityManager().createQuery(cq).getResultList();

    }

    public void createPayment(Payment payment) {
        paymentJpa.create(payment);
    }

    public void editClient(Client c) throws Exception {
        clientJpa.edit(c);
    }

    public void deleteClient(int clientId) throws NonexistentEntityException {
        clientJpa.destroy(clientId);
    }

    public List<Document> getDocuments(int clientId) {
        CriteriaBuilder cb = paymentJpa.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Document> cq = cb.createQuery(Document.class);
        Root<Document> doc = cq.from(Document.class);
        Predicate p = cb.equal(doc.get("client").get("id"), clientId);
        cq.where(p);
        return paymentJpa.getEntityManager().createQuery(cq).getResultList();

    }

    public List<Document> getDocuments() {
        return documentJpa.findDocumentEntities();
    }

    public boolean createDocument(Document d) {
        try {
            documentJpa.create(d);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
