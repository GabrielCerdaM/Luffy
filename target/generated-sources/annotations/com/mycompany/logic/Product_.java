package com.mycompany.logic;

import com.mycompany.logic.Provider;
import com.mycompany.logic.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T13:58:36", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-28T22:34:47", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> 020dcfe9f96ea23574fa2a92cbc843cf9df76c26
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-28T23:00:31", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> 38a889aa182ea29eeb4bbfae38339f16423da9d6
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-29T14:33:16", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> 5f5e21623d34448e53f7a551731a4f8a70b344c9
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Provider> provider;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Integer> stock;
    public static volatile SingularAttribute<Product, Subcategory> subcategory;

}