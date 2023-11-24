/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Gabriel
 */
@Entity
public class Sale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String date;
    private String hour;
    private int total;
    private double iva;
    @OneToMany(mappedBy = "sale")
    private List<DetailSale> detailSale;

    public Sale() {
    }

    public Sale(int id, String date, String hour, int total, double iva, List<DetailSale> detailSale) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.total = total;
        this.iva = iva;
        this.detailSale = detailSale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public List<DetailSale> getDetailSale() {
        return detailSale;
    }

    public void setDetailSale(List<DetailSale> detailSale) {
        this.detailSale = detailSale;
    }
    
}
