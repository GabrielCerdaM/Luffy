/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logic;

import com.mycompany.persistance.PersistanceController;
import com.mycompany.persistance.exceptions.NonexistentEntityException;
import com.mycompany.utils.Utils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Controller {

    PersistanceController persistanceController = new PersistanceController();

    public User login(String username, char[] password) {
        List<User> users = persistanceController.getUsers();
        User userFinded;
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                if (Arrays.equals(password, user.getPassword().toCharArray())) {
                    userFinded = user;
                    return userFinded;
                }
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return persistanceController.getUsers();
    }

    public List<Rol> getRols() {
        return persistanceController.getRols();
    }

    public boolean createUser(String username, char[] password, String rol) {
        User newUser = new User();
        newUser.setUsername(username);
        String myPass = String.valueOf(password);
        newUser.setPassword(myPass);
        Rol role = getRol(rol);
        if (role == null) {
            return false;
        }
        newUser.setRol(role);
        int id = getLastUserId();
        newUser.setId(id + 1);
        return persistanceController.createUser(newUser);
    }

    public Rol getRol(String name) {
        List<Rol> roles = persistanceController.getRols();
        for (Rol rol : roles) {
            if (rol.getName().equals(name)) {
                return rol;
            }
        }
        return null;
    }

    public Subcategory getSubcategory(int subcategoryId) {
        return persistanceController.getSubcategory(subcategoryId);
    }

    public Subcategory getSubcategoryByName(String name) {
        System.out.println(name);
        List<Subcategory> subcategories = persistanceController.getSubcategories();
        for (Subcategory sc : subcategories) {
            if (sc.getName().equals(name)) {
                return sc;
            }
        }
        return null;
    }

    private int getLastPaymentId() {
        List<Payment> payments = getAllPayments();
        int size = payments.size() - 1;
        if (size == -1) {
            return 0;
        }
        Payment p = payments.get(size);
        return p.getId();
    }

    public int getLastUserId() {
        List<User> users = getUsers();
        int size = users.size() - 1;
        if (size == -1) {
            return 0;
        }
        User user = users.get(size);
        return user.getId();
    }

    public int getLastClientId() {
        List<Client> c = getClients();
        int size = c.size() - 1;
        if (size == -1) {
            return 0;
        }
        Client client = c.get(size);
        return client.getId();
    }

    public int getLastCategoryId() {
        List<Category> categories = getCategories();
        int size = categories.size() - 1;
        if (size == -1) {
            return 0;
        }
        Category category = categories.get(categories.size() - 1);
        return category.getId();
    }

    public int getLastProductId() {
        List<Product> products = getProducts();
        int size = products.size() - 1;
        if (size == -1) {
            return 0;
        }
        Product p = products.get(products.size() - 1);
        return p.getId();
    }

    public void deleteUser(int userId) {
        persistanceController.deleteUser(userId);
    }

    public User getUser(int userId) {
        return persistanceController.getUser(userId);
    }

    public void editUser(User user, String username, char[] password, String rolName) throws Exception {
        Rol rol = getRol(rolName);
        if (rol != null) {
            user.setUsername(username);
            user.setPassword(String.valueOf(password));
            user.setRol(rol);
            persistanceController.editUser(user);
        } else {
            Utils.showMessage("El campo rol es obligatorio", "Info", "Requiere completar campos pendientes");
        }
    }

    public List<Category> getCategories() {
        return persistanceController.getCategories();
    }

    public void deleteCategory(int categoryId) {
        persistanceController.deleteCategory(categoryId);
    }

    public void createCategory(String name, String description) {
        Category category = new Category();
        int lastId = getLastCategoryId();
        category.setId(lastId + 1);
        category.setName(name);
        category.setDescription(description);
        persistanceController.createCategory(category);
    }

    public Category getCategory(int categoryId) {
        return persistanceController.getCategory(categoryId);
    }

    public void editCategory(Category category, String name, String description) throws Exception {
        category.setName(name);
        category.setDescription(description);
        persistanceController.editCategory(category);
    }

    public void createSubcategory(String name, String description, String categoryName) {
        Subcategory sc = new Subcategory();
        sc.setName(name);
        sc.setDescription(description);
        Category category = this.getCategoryByName(categoryName);
        sc.setCategory(category);
        persistanceController.createSubcategory(sc);
    }

    public List<Subcategory> getSubcategories() {
        return persistanceController.getSubcategories();
    }

    public List<Subcategory> getSubcategories(int categoryId) {
        return persistanceController.getSubcategories(categoryId);
    }

    public Category getCategoryByName(String categoryName) {
        List<Category> categories = persistanceController.getCategories();
        for (Category c : categories) {
            if (c.getName().equals(categoryName)) {
                return c;
            }
        }
        return null;
    }

    public void deleteSubcategory(int subcategoryId) throws NonexistentEntityException {
        persistanceController.deleteSubcategory(subcategoryId);
    }

    public List<Product> getProducts() {
        return persistanceController.getProducts();
    }

    public void deleteProduct(int productId) throws NonexistentEntityException {
        persistanceController.deleteProduct(productId);
    }

    public List<Provider> getProviders() {
        return persistanceController.getProviders();
    }

    public Product getProduct(int productId) {
        return persistanceController.getProduct(productId);
    }

    public void editSubcategory(Subcategory subcategory, String name, String description, String category) throws Exception {

        Category categ = getCategoryByName(category);
        if (categ != null) {
            subcategory.setName(name);
            subcategory.setDescription(description);
            subcategory.setCategory(categ);
            persistanceController.editSubcagetory(subcategory);
        } else {
            Utils.showMessage("Error al editar subcategoria, nose ha encontrado la categoria seleccionada", "Info", "Requiere completar campos pendientes");
        }
    }

    public void editProduct(Product product, String name, int price, int stock, String category, String subcategory, String provider) throws Exception {
        Subcategory sc = getSubcategoryByName(subcategory);
        Provider p = getProviderByName(provider);
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setSubcategory(sc);
        product.setProvider(p);
        persistanceController.editProduct(product);
    }

    public Provider getProviderByName(String providerName) {
        List<Provider> providers = persistanceController.getProviders();
        for (Provider p : providers) {
            if (p.getName().equals(providerName)) {
                return p;
            }
        }
        return null;
    }

    public void createProduct(String name, int price, int stock, String categoryName, String subcategoryName, String providerName) {
        Product product = new Product();

        Category c = getCategoryByName(categoryName);
        Subcategory sc = getSubcategoryByName(subcategoryName);
        Provider p = getProviderByName(providerName);
        int lastProductId = getLastProductId();
        product.setId(lastProductId + 1);
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setSubcategory(sc);
        product.setProvider(p);
        persistanceController.createProduct(product);
    }

    public List<Sale> getSales() {
        return persistanceController.getSales();
    }

    public List<DetailSale> getAllDetailSale() {
        return persistanceController.getAllDetailSale();
    }

    public int getLastDetailTicketId() {
        List<DetailSale> ds = getAllDetailSale();
        int size = ds.size() - 1;
        if (size == -1) {
            return 0;
        }
        DetailSale dSale = ds.get(size);
        return dSale.getId();
    }

    public int getLastSaleId() {
        List<Sale> sales = getSales();
        int size = sales.size() - 1;
        if (size == -1) {
            return 0;
        }
        Sale sale = sales.get(size);
        return sale.getId();
    }

    public List<DetailSale> getDetailSale(int saleId) {
        return persistanceController.getDetailSale(saleId);
    }

//    public void createSale(Sale sale) {
//        int lastSaleId = getLastSaleId();
//        System.out.println("lastSaleId "+lastSaleId);
//        sale.setId(lastSaleId + 1);
//        persistanceController.createSale(sale);
//    }
    public void createSale(List<DetailSale> list, Client client) {
        int lastSaleId = getLastSaleId();
        int lastDetailId = getLastDetailId();

        int total = 0;

        Sale sale = new Sale();
        sale.setId(lastSaleId + 1);
        sale.setClient(client);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSale(sale);
            int quantity = i + 1;
            list.get(i).setId(lastDetailId + quantity);
            total = total + (list.get(i).getProduct().getPrice() * list.get(i).getQuantity());
        }

        sale.setDetailSale(list);
        sale.setTotal(total);
        sale.setIva(total * 0.89);
        persistanceController.createSale(sale);
    }

    public void createProvider(String name, String description, String phone, String address) {
        Provider p = new Provider();
        int idLastProvider = getIdLastProvider() + 1;
        p.setId(idLastProvider);
        p.setName(name);
        p.setDescription(description);
        p.setPhone(phone);
        p.setAddress(address);
        persistanceController.createProvider(p);
    }

    private int getIdLastProvider() {
        List<Provider> providers = getProviders();
        int size = providers.size() - 1;
        if (size == -1) {
            return 0;
        }
        Provider p = providers.get(size);
        return p.getId();
    }

    private List<Product> getProductBy(int subcategoryId) {
        return persistanceController.getProductBy(subcategoryId);
    }

    public List<Product> getProductFiltered(String search, String categoryName, String subcategoryName, String providerName) {
        return persistanceController.getFilterProducts(search, categoryName, subcategoryName, providerName);
    }

    public List<Client> getClients() {
        return persistanceController.getClients();
    }

    public List<Client> getClients(String search) {
        return persistanceController.getClients(search);
    }

    public Client getClientById(int clientId) {
        return persistanceController.getClientById(clientId);
    }

    public void createClient(String rut, String name, String phone, String email, String address, String rutDeceased, String nameDeceased, Date dateDeceased, String wakeAddress, int carriage, int accompaniment, int announcements, String url, String color, String cementery, String kindship, int price, String benefit, int amountBenefit) {
        int id = getLastClientId();
        Client c = new Client();
        c.setId(id + 1);
        c.setRut(rut);
        c.setName(name);
        c.setPhone(phone);
        c.setEmail(email);
        c.setAddress(address);
        c.setRutDeceased(rutDeceased);
        c.setNameDeceased(nameDeceased);
        c.setDateDeceased(dateDeceased);
        c.setWakeAddress(wakeAddress);
        c.setCarriage(carriage);
        c.setAccompaniment(accompaniment);
        c.setAnnouncements(announcements);
        c.setUrn(url);
        c.setColor(color);
        c.setCementery(cementery);
        c.setKindship(kindship);
        c.setPrice(price);
        c.setBenefit(benefit);
        c.setAmountBenefit(amountBenefit);

        persistanceController.createClient(c);
    }

    public int getLastDetailId() {
        List<DetailSale> list = persistanceController.getAllDetailSale();
        int size = list.size() - 1;
        if (size == -1) {
            return 0;
        }
        DetailSale d = list.get(size);
        return d.getId();
    }

    public List<Payment> getPayments(int clientId) {
        return persistanceController.getPayments(clientId);
    }

    public void createPayment(Client client, int amountValue) {
        int id = getLastPaymentId();
        Payment p = new Payment();
        p.setId(id + 1);
        p.setClient(client);
        p.setAmount(amountValue);
        persistanceController.createPayment(p);
    }

    private List<Payment> getAllPayments() {
       return persistanceController.getPayments();
    }

    public void editClient(Client c,String phone, String email, String address, String wakeAddress, int carriageValue, int accompanimentValue, int announcementsValue, String color, String cementery) throws Exception {
        c.setPhone(phone);
        c.setEmail(email);
        c.setWakeAddress(wakeAddress);
        c.setCarriage(carriageValue);
        c.setAccompaniment(accompanimentValue);
        c.setAnnouncements(announcementsValue);
        c.setColor(color);
        c.setCementery(cementery);
        persistanceController.editClient(c);
    }

    public void deleteClient(int clientId) {
        try {
            persistanceController.deleteClient(clientId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
