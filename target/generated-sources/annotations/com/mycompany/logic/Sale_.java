package com.mycompany.logic;

import com.mycompany.logic.DetailSale;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-23T21:24:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, String> date;
    public static volatile SingularAttribute<Sale, Integer> total;
    public static volatile ListAttribute<Sale, DetailSale> detailSale;
    public static volatile SingularAttribute<Sale, String> hour;
    public static volatile SingularAttribute<Sale, Double> iva;
    public static volatile SingularAttribute<Sale, Integer> id;

}