/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.igu.Sale;

import com.mycompany.logic.Controller;
import com.mycompany.logic.Sale;
import com.mycompany.logic.User;
import com.mycompany.utils.Utils;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class SaleViewAdmin extends javax.swing.JFrame {

    Controller controller;
    User user;
    /**
     * Creates new form SaleViewAdmin
     */
    public SaleViewAdmin(Controller controller,User user) {
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

        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnExit5 = new javax.swing.JButton();
        btnLoadTable5 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableSale = new javax.swing.JTable();
        txtUserLogged5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel6.setText("Sistema administrador de Ventas");

        btnExit5.setText("Salir");
        btnExit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit5ActionPerformed(evt);
            }
        });

        btnLoadTable5.setText("Recarga tabla");
        btnLoadTable5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTable5ActionPerformed(evt);
            }
        });

        tableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tableSale);

        txtUserLogged5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUserLogged5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLoadTable5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUserLogged5)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(btnLoadTable5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExit5ActionPerformed

    private void btnLoadTable5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTable5ActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnLoadTable5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit5;
    private javax.swing.JButton btnLoadTable5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tableSale;
    private javax.swing.JLabel txtUserLogged5;
    // End of variables declaration//GEN-END:variables

    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }            
        };
        
        String[] titles = {"id","fecha","hora","total"};
        model.setColumnIdentifiers(titles);

        List<Sale> sales = controller.getSales();
        for(Sale sale: sales){
            Object[] o = new Object[]{sale.getId(),sale.getDate(),sale.getHour(),sale.getTotal()};
            model.addRow(o);
        }
        
        tableSale.setModel(model);
    }

        
    private int getSelectedFromTable(){
        if(tableSale.getRowCount() > 0){
            if(tableSale.getSelectedRow() != -1){
                Object object = tableSale.getValueAt(tableSale.getSelectedRow(),0);
                int saleId = Integer.parseInt(String.valueOf(object));
                return saleId;
          }else{
            Utils.showMessage("Ninguna fila ha sido seleccionada", "Error", "Error");
          }
        }else{
              Utils.showMessage("La Lista se encuentra vacia", "Error", "Errors");          
        }
        return 0;
    }
}
