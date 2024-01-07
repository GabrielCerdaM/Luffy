package com.mycompany.logic;

import com.mycompany.logic.Client;
import com.mycompany.logic.DetailSale;
import com.mycompany.logic.Document;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-07T19:37:18", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, LocalDateTime> createdAt;
    public static volatile SingularAttribute<Sale, Integer> total;
    public static volatile ListAttribute<Sale, DetailSale> detailSale;
    public static volatile SingularAttribute<Sale, LocalDateTime> deletedAt;
    public static volatile SingularAttribute<Sale, Double> iva;
    public static volatile SingularAttribute<Sale, Boolean> payment_status;
    public static volatile ListAttribute<Sale, Document> document;
    public static volatile SingularAttribute<Sale, Client> client;
    public static volatile SingularAttribute<Sale, Integer> id;
    public static volatile SingularAttribute<Sale, LocalDateTime> updatedAt;

}