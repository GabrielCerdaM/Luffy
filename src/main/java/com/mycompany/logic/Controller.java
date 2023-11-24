/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logic;

import com.mycompany.persistance.PersistanceController;
import com.mycompany.persistance.exceptions.NonexistentEntityException;
import com.mycompany.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Controller {
    PersistanceController persistanceController = new PersistanceController();

    public User login(String username, char[] password) {
        List<User> users = persistanceController.getUsers();
        User userFinded;
        for(User user: users){
            if(username.equals(user.getUsername())){
                if(Arrays.equals(password,user.getPassword().toCharArray())){
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
    
    public List<Rol> getRols(){
        return persistanceController.getRols();
    }

    public boolean createUser(String username, char[] password, String rol) {
        User newUser = new User();
        newUser.setUsername(username);
        String myPass=String.valueOf(password);
        newUser.setPassword(myPass);
        Rol role = getRol(rol);
        if(role==null){
            return false;
        }
        newUser.setRol(role);
        int id = getLastUserId();
        newUser.setId(id + 1);
        return persistanceController.createUser(newUser);
    }

    public Rol getRol(String name){
        List<Rol> roles = persistanceController.getRols();
        for(Rol rol : roles){
            if(rol.getName().equals(name)){
                return rol;
            }
        }
        return null;
    }
    
    public Subcategory getSubcategory(int subcategoryId){
        return persistanceController.getSubcategory(subcategoryId);
    }
    
    public Subcategory getSubcategoryByName(String name){
        System.out.println(name);
        List<Subcategory> subcategories = persistanceController.getSubcategories();
        for(Subcategory sc : subcategories){
            if(sc.getName().equals(name)){
                return sc;
            }
        }
        return null;
    }
    
    public int getLastUserId(){
        List<User> users = getUsers();
        int size = users.size()-1;
        if(size == -1){
            return 0;
        }
        User user = users.get(size);        
        return user.getId();
    }

    public int getLastCategoryId(){
        List<Category> categories = getCategories();
        int size = categories.size()-1;
        if(size == -1){
            return 0;
        }
        Category category = categories.get(categories.size()-1);
        return category.getId();
    }
    
    public int getLastProductId(){
        List<Product> products = getProducts();
        int size = products.size()-1;
        if(size == -1){
            return 0;
        }
        Product p = products.get(products.size()-1);
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
        if(rol!=null){
            user.setUsername(username);
            user.setPassword(String.valueOf(password));
            user.setRol(rol);
            persistanceController.editUser(user);        
        }else{
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
        for(Category c : categories){
            if(c.getName().equals(categoryName)){
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
        if(categ!=null){
            subcategory.setName(name);
            subcategory.setDescription(description);
            subcategory.setCategory(categ);
            persistanceController.editSubcagetory(subcategory);        
        }else{
            Utils.showMessage("Error al editar subcategoria, nose ha encontrado la categoria seleccionada", "Info", "Requiere completar campos pendientes");
        }
    }

    public void editProduct(Product product, String name, int price,int stock, String category, String subcategory, String provider) throws Exception {
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
        for(Provider p: providers){
            if(p.getName().equals(providerName)){
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
        product.setId(lastProductId + 1 );
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
        int size = ds.size() -1;
        if(size == -1){
            return 0;
        }
        DetailSale dSale = ds.get(size);        
        return dSale.getId();
    }

    public List<DetailSale> getDetailSale(int saleId) {
        return persistanceController.getDetailSale(saleId);
    }

}
