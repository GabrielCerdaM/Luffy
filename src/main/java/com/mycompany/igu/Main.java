/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.igu;

import com.mycompany.logic.Controller;
import com.mycompany.persistance.PersistanceController;

/**
 *
 * @author Gabriel
 */
public class Main {

    public static void main(String[] args) {
        try {
            PersistanceController p = new PersistanceController();
            Controller c = new Controller(p);
            Login login = new Login(c);
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } catch (Exception e) {
            System.out.println("MAIN ERROR: "+e.getMessage());
        }
    }
}
