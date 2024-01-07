package com.mycompany.logic;

import com.mycompany.logic.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-06T23:34:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Provider.class)
public class Provider_ { 

    public static volatile SingularAttribute<Provider, String> address;
    public static volatile SingularAttribute<Provider, String> phone;
    public static volatile SingularAttribute<Provider, String> name;
    public static volatile SingularAttribute<Provider, String> description;
    public static volatile SingularAttribute<Provider, Integer> id;
    public static volatile ListAttribute<Provider, Product> products;

}