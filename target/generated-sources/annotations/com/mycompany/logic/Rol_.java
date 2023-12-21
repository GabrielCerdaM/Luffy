package com.mycompany.logic;

import com.mycompany.logic.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-20T19:50:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> name;
    public static volatile SingularAttribute<Rol, String> description;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile ListAttribute<Rol, User> users;

}