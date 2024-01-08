package com.mycompany.logic;

import com.mycompany.logic.Provider;
import com.mycompany.logic.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-07T23:46:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Provider> provider;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Integer> stock;
    public static volatile SingularAttribute<Product, Subcategory> subcategory;

}