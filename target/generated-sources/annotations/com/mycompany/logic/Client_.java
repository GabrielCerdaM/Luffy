package com.mycompany.logic;

import com.mycompany.logic.Payment;
import com.mycompany.logic.Sale;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-07T19:37:18", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> address;
    public static volatile SingularAttribute<Client, Integer> carriage;
    public static volatile SingularAttribute<Client, String> color;
    public static volatile ListAttribute<Client, Payment> payments;
    public static volatile SingularAttribute<Client, Date> dateDeceased;
    public static volatile SingularAttribute<Client, String> kindship;
    public static volatile SingularAttribute<Client, String> nameDeceased;
    public static volatile SingularAttribute<Client, String> benefit;
    public static volatile SingularAttribute<Client, String> rut;
    public static volatile SingularAttribute<Client, String> urn;
    public static volatile ListAttribute<Client, Sale> sale;
    public static volatile SingularAttribute<Client, String> wakeAddress;
    public static volatile SingularAttribute<Client, String> phone;
    public static volatile SingularAttribute<Client, Integer> price;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, String> rutDeceased;
    public static volatile SingularAttribute<Client, Integer> amountBenefit;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, Integer> accompaniment;
    public static volatile SingularAttribute<Client, Integer> announcements;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, String> cementery;

}