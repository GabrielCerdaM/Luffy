/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.igu.Product;

import com.mycompany.igu.home.admin.HomeAdmin;
import com.mycompany.logic.Category;
import com.mycompany.logic.Controller;
import com.mycompany.logic.Product;
import com.mycompany.logic.Provider;
import com.mycompany.logic.Subcategory;
import com.mycompany.logic.User;
import com.mycompany.persistance.exceptions.NonexistentEntityException;
import com.mycompany.utils.Utils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class ProductView extends javax.swing.JFrame {
    Controller controller;
    User user;
    /**
     * Creates new form ProductView
     */
    public ProductView(Controller controller,User user) {
        initComponents();
        this.controller = controller;
        this.user = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEditProduct = new javax.swing.JButton();
        btnCreateProduct = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnLoadTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        txtUserLogged = new javax.swing.JLabel();
        cmbSubcategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbProvider = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Sistema administracion de productos");

        btnEditProduct.setText("Editar producto");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnCreateProduct.setText("Crear nuevo producto");
        btnCreateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProductActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDeleteProduct.setText("Borrar producto");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnLoadTable.setText("Recarga tabla");
        btnLoadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTableActionPerformed(evt);
            }
        });

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProduct);

        txtUserLogged.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        cmbSubcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subcategoria" }));

        jLabel2.setText("Subcategoria:");

        jLabel3.setText("Proveedor");

        cmbProvider.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor" }));

        jLabel4.setText("Subcategoria:");

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria" }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        btnFilter.setText("Filtrar");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 871, Short.MAX_VALUE)
                        .addComponent(txtUserLogged, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearch)
                                    .addComponent(cmbCategory, 0, 136, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSubcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLoadTable, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnDeleteProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnCreateProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUserLogged)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSubcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadTable, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        int productId = getSelectedFromTable();
        if(productId > 0){
            EditProduct editView = new EditProduct(controller,user, productId);
            editView.setVisible(true);
            editView.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void btnCreateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProductActionPerformed
        // TODO add your handling code here:
        CreateProduct productView = new CreateProduct(controller, user);
        productView.setVisible(true);
        productView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCreateProductActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        goToHomeView();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        int productId = getSelectedFromTable();
        if(productId > 0){
            try {
                controller.deleteProduct(productId);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadTable();
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnLoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTableActionPerformed
        // TODO add your handling code here:
        loadTable();
        loadComboBoxes();
    }//GEN-LAST:event_btnLoadTableActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loadTable();
        loadComboBoxes();
    }//GEN-LAST:event_formWindowOpened

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
        if(cmbCategory.getSelectedIndex() == -1){
            return;
        }
        if(cmbCategory.getSelectedIndex() == 0){
            cmbSubcategory.removeAllItems();
            loadSubcategories(0);
        }else{
            String scName = String.valueOf(cmbCategory.getSelectedItem());
            Category category = controller.getCategoryByName(scName);
            loadSubcategories(category.getId());
        }
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        String itemProviderSelected ="";
        String itemCategorySelected ="";
        String itemSubcategorySelected="";

        if(
                (txtSearch.getText().isEmpty() ||
                txtSearch.getText() == null) &&
                cmbCategory.getSelectedIndex() == 0 &&
                cmbSubcategory.getSelectedIndex() == 0 &&
                cmbProvider.getSelectedIndex() == 0
                ){
            loadTable();
            return;
        }

        if(cmbSubcategory.getSelectedIndex() != -1 &&
                cmbSubcategory.getSelectedIndex() > 0){
            itemCategorySelected = String.valueOf(cmbCategory.getSelectedItem());        
        }else{
            if(cmbCategory.getSelectedIndex() != -1 &&
                cmbCategory.getSelectedIndex() > 0){
                itemCategorySelected = String.valueOf(cmbCategory.getSelectedItem());        
            }
        }
        if(cmbProvider.getSelectedIndex() != -1 &&
                cmbProvider.getSelectedIndex() > 0){
            itemProviderSelected = String.valueOf(cmbProvider.getSelectedItem());        
        }

        String search = txtSearch.getText();
        
        List<Product> products = controller.getProductFiltered(search,itemCategorySelected, itemSubcategorySelected, itemProviderSelected);
        System.out.println("size "+products.size());
        loadTable(products);
    }//GEN-LAST:event_btnFilterActionPerformed

    private void loadTable(List<Product> products){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String titulos[] = {"Id","Nombre","Precio","Subcategoria","Categoria","proveedor","stock"};
        model.setColumnIdentifiers(titulos);

        if(products != null){
            for(Product p : products){
                Object[] o = new Object[]{p.getId(),p.getName(),p.getPrice(),p.getSubcategory().getName(),p.getSubcategory().getCategory().getName(),p.getProvider().getName(),p.getStock()};
                model.addRow(o);
            }
        }
        tableProduct.setModel(model);
    }
    
    private void loadTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String titulos[] = {"Id","Nombre","Precio","Subcategoria","Categoria","proveedor","stock"};
        model.setColumnIdentifiers(titulos);

        List<Product> products = controller.getProducts();
        if(products != null){
            for(Product p : products){
                Object[] o = new Object[]{p.getId(),p.getName(),p.getPrice(),p.getSubcategory().getName(),p.getSubcategory().getCategory().getName(),p.getProvider().getName(),p.getStock()};
                model.addRow(o);
            }
        }
        tableProduct.setModel(model);
    }
    
    private int getSelectedFromTable(){
        if(tableProduct.getRowCount() > 0){
            if(tableProduct.getSelectedRow() != -1){
                Object object = tableProduct.getValueAt(tableProduct.getSelectedRow(),0);
                int productId = Integer.parseInt(String.valueOf(object));
                return productId;
          }else{
            Utils.showMessage("Ninguna fila ha sido seleccionada", "Error", "Error");
          }
        }else{
              Utils.showMessage("La Lista se encuentra vacia", "Error", "Errors");          
        }
        return 0;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLoadTable;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbProvider;
    private javax.swing.JComboBox<String> cmbSubcategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtUserLogged;
    // End of variables declaration//GEN-END:variables

    private void loadComboBoxes(){
        loadCategories();
        loadProviders();
    }
    private void loadProviders() {
        List<Provider> providers = controller.getProviders();
        cmbProvider.removeAllItems();
        cmbProvider.addItem("Proveedor");
        if(providers != null){
            for(Provider p: providers){
                cmbProvider.addItem(p.getName());
            }
        }
    }
    
    private void loadCategories() {
        cmbSubcategory.removeAllItems();
        List<Category> categories = controller.getCategories();
        cmbCategory.removeAllItems();
        cmbCategory.addItem("categoria");
        if(categories != null){
            for(Category c: categories){
                cmbCategory.addItem(c.getName());
            }
        }
    }
    
    private void loadSubcategories(int categoryId) {
        cmbSubcategory.removeAllItems();
        cmbSubcategory.addItem("Subcategoria");
        if(categoryId != 0){
            List<Subcategory> subcategories = controller.getSubcategories(categoryId);
            if(subcategories != null){
                for(int i=0;i<=subcategories.size()-1;i++){
                    cmbSubcategory.addItem(subcategories.get(i).getName());
                }
            }        
        }

    }
    
    private void goToHomeView() {
        HomeAdmin hView = new HomeAdmin(controller, user);
        hView.setVisible(true);
        hView.setLocationRelativeTo(null);
        this.dispose();
    }
}
