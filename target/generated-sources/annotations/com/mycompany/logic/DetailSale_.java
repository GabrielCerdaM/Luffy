package com.mycompany.logic;

import com.mycompany.logic.Product;
import com.mycompany.logic.Sale;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-23T21:24:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(DetailSale.class)
public class DetailSale_ { 

    public static volatile SingularAttribute<DetailSale, Integer> total;
    public static volatile SingularAttribute<DetailSale, Product> product;
    public static volatile SingularAttribute<DetailSale, Sale> sale;
    public static volatile SingularAttribute<DetailSale, Integer> count;
    public static volatile SingularAttribute<DetailSale, Integer> id;

}