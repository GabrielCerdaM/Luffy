/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.igu.ticket;

import com.mycompany.igu.home.admin.HomeAdmin;
import com.mycompany.logic.Controller;
import com.mycompany.logic.DetailSale;
import com.mycompany.logic.Product;
import com.mycompany.logic.Sale;
import com.mycompany.logic.User;
import com.mycompany.utils.Utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class Ticket extends javax.swing.JFrame {

    private Controller controller;
    private User user;
    private Sale sale;
    private List<DetailSale> detailSale;
    private List<Product> products;
    /**
     * Creates new form Ticket
     */
    public Ticket(Controller controller, User user) {
        initComponents();
        this.controller = controller;
        this.user = user;
        detailSale = new ArrayList<DetailSale>();
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
        btnAddProduct = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnLoadTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetailSale = new javax.swing.JTable();
        txtUserLogged = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        counter = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Punto de venta");

        btnEditProduct.setText("Editar producto");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnAddProduct.setText("Agregar producto");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
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

        tableDetailSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDetailSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDetailSaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDetailSale);

        txtUserLogged.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jLabel2.setText("Search:");

        counter.setModel(new javax.swing.SpinnerNumberModel(0, null, 200, 1));

        jLabel3.setText("cantidad:");

        btnSave.setText("Guardar Ticket");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserLogged, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLoadTable, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnEditProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUserLogged)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadTable, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        try {
            int index = getSelectedFromDetailSaleTable();
            if(index!=0){
                Object spinner = counter.getValue();
                int count = Integer.parseInt(String.valueOf(spinner));
                detailSale.get(index).setCount(count);            
            }
        } catch (Exception e) {
            Utils.showMessage(e.getMessage(),"Error", "Error al editar usuario");
        }
        cleanForm();
        loadTable();
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        boolean exist = false;
        String search = txtSearch.getText();
        try {
            int productId = Integer.parseInt(search);
            Object spinner = counter.getValue();
            int count = Integer.parseInt(String.valueOf(spinner));
            if (true && count > 0) {
//        if(!search.isEmpty()){
                // buscar el producto
                Product p = controller.getProduct(productId);
                if (p == null) {
                    return;
                }
                //agregar producto al detalle
                for (DetailSale ds : detailSale) {
                    //valida existencia de producto en el carro
                    if (ds.getProduct().getId() == p.getId()) {
                        ds.setCount(ds.getCount() + count);
                        exist = true;
                    }
                }

                if (!exist) {
                    DetailSale newDs = new DetailSale();
                    newDs.setProduct(p);
                    newDs.setCount(count);
                    newDs.setTotal(newDs.getCount() * newDs.getProduct().getPrice());
                    detailSale.add(newDs);
                }
            }
            loadTable();
            cleanForm();
        } catch (Exception e) {
            Utils.showMessage("Campo no valido", "Error", "Error de busqueda");
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        HomeAdmin hView = new HomeAdmin(controller, user);
        hView.setVisible(true);
        hView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        int index = getSelectedFromDetailSaleTable();
        detailSale.remove(index);
        loadTable();
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnLoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTableActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnLoadTableActionPerformed

    private void tableDetailSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDetailSaleMouseClicked
        // TODO add your handling code here:
        int index = getSelectedFromDetailSaleTable();
        if(index != -1){
            counter.setValue(detailSale.get(index).getCount()); 
        }
    }//GEN-LAST:event_tableDetailSaleMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(detailSale.size() < 0){
            return;
        }
        Sale sale = new Sale();
        int total = 0;
        for(DetailSale ds : detailSale){
            total = total + (ds.getProduct().getPrice() * ds.getCount());
        }
        sale.setDetailSale(detailSale);

        sale.setTotal(total);
        sale.setIva(total * 0.89);
        controller.createSale(sale);
        loadTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index = getSelectedFromProductTable();
        txtSearch.setText(String.valueOf(products.get(index).getId()));
        counter.setValue(1);
    }//GEN-LAST:event_tableProductMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loadProductTable();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoadTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JSpinner counter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableDetailSale;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtUserLogged;
    // End of variables declaration//GEN-END:variables

    private void loadTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        };
        
        String[] title = {"nombre producto","cantidad","precio","total"};
        model.setColumnIdentifiers(title);
        
        for(DetailSale ds: detailSale){
            Object[] o = new Object[]{ds.getProduct().getName(),ds.getCount(),ds.getProduct().getPrice(),ds.getTotal()};
            model.addRow(o);
        }
        tableDetailSale.setModel(model);
    }
    
    private void cleanForm() {
        txtSearch.setText("");
        counter.setValue(0);
    }
    
    private int getSelectedFromProductTable(){
        if(tableProduct.getRowCount() > 0){
            if(tableProduct.getSelectedRow() != -1){
                int index = tableProduct.getSelectedRow();
                return index;
          }else{
            Utils.showMessage("Ninguna fila ha sido seleccionada", "Error", "Error");
          }
        }else{
              Utils.showMessage("La Lista se encuentra vacia", "Error", "Errors");          
        }
        return 0;
    }


    private int getSelectedFromDetailSaleTable(){
        if(tableDetailSale.getRowCount() > 0){
            if(tableDetailSale.getSelectedRow() != -1){
                int index = tableDetailSale.getSelectedRow();
                return index;
          }else{
            Utils.showMessage("Ninguna fila ha sido seleccionada", "Error", "Error");
          }
        }else{
              Utils.showMessage("La Lista se encuentra vacia", "Error", "Errors");          
        }
        return 0;
    }
    
        private void loadProductTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String titulos[] = {"Id","Nombre","Precio","Stock"};
        model.setColumnIdentifiers(titulos);

        products = controller.getProducts();
        if(products != null){
            for(Product p : products){
                Object[] o = new Object[]{p.getId(),p.getName(),p.getPrice(),p.getStock()};
                model.addRow(o);
            }
        }
        tableProduct.setModel(model);
    }
}
