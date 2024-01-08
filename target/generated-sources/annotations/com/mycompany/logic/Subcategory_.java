package com.mycompany.logic;

import com.mycompany.logic.Category;
import com.mycompany.logic.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-07T23:46:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Subcategory.class)
public class Subcategory_ { 

    public static volatile SingularAttribute<Subcategory, String> name;
    public static volatile SingularAttribute<Subcategory, String> description;
    public static volatile SingularAttribute<Subcategory, Integer> id;
    public static volatile SingularAttribute<Subcategory, Category> category;
    public static volatile ListAttribute<Subcategory, Product> products;

}