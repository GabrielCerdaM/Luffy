/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String rut;
    private String name;
    private String phone;
    private String email;
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Sale> sale;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Payment> payments;

    private String rutDeceased;
    private String nameDeceased;
    private Date dateDeceased;
    private String wakeAddress;
    private int carriage;
    private int accompaniment;
    private int announcements;
    private String urn;
    private String color;
    private String cementery;
    private String kindship;
    private int price;
    private String benefit;
    private int amountBenefit;

    public Client() {
    }

    public Client(int id, String rut, String name, String phone, String email, String address, List<Sale> sale, List<Payment> payments, String rutDeceased, String nameDeceased, Date dateDeceased, String wakeAddress, int carriage, int accompaniment, int announcements, String urn, String color, String cementery, String kindship, int price, String benefit, int amountBenefit) {
        this.id = id;
        this.rut = rut;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.sale = sale;
        this.payments = payments;
        this.rutDeceased = rutDeceased;
        this.nameDeceased = nameDeceased;
        this.dateDeceased = dateDeceased;
        this.wakeAddress = wakeAddress;
        this.carriage = carriage;
        this.accompaniment = accompaniment;
        this.announcements = announcements;
        this.urn = urn;
        this.color = color;
        this.cementery = cementery;
        this.kindship = kindship;
        this.price = price;
        this.benefit = benefit;
        this.amountBenefit = amountBenefit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getRutDeceased() {
        return rutDeceased;
    }

    public void setRutDeceased(String rutDeceased) {
        this.rutDeceased = rutDeceased;
    }

    public String getNameDeceased() {
        return nameDeceased;
    }

    public void setNameDeceased(String nameDeceased) {
        this.nameDeceased = nameDeceased;
    }

    public Date getDateDeceased() {
        return dateDeceased;
    }

    public void setDateDeceased(Date dateDeceased) {
        this.dateDeceased = dateDeceased;
    }

    public String getWakeAddress() {
        return wakeAddress;
    }

    public void setWakeAddress(String wakeAddress) {
        this.wakeAddress = wakeAddress;
    }

    public int getCarriage() {
        return carriage;
    }

    public void setCarriage(int carriage) {
        this.carriage = carriage;
    }

    public int getAccompaniment() {
        return accompaniment;
    }

    public void setAccompaniment(int accompaniment) {
        this.accompaniment = accompaniment;
    }

    public int getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(int announcements) {
        this.announcements = announcements;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCementery() {
        return cementery;
    }

    public void setCementery(String cementery) {
        this.cementery = cementery;
    }

    public String getKindship() {
        return kindship;
    }

    public void setKindship(String kindship) {
        this.kindship = kindship;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public int getAmountBenefit() {
        return amountBenefit;
    }

    public void setAmountBenefit(int amountBenefit) {
        this.amountBenefit = amountBenefit;
    }

    @Override
    public String toString() {
        return getRut() + " - " + getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Client client = (Client) obj;
        return Objects.equals(this.getId(), client.id); // Reemplaza "id" con el atributo que identifica de manera única al cliente
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId()); // Reemplaza "id" con el atributo que identifica de manera única al cliente
    }
}
