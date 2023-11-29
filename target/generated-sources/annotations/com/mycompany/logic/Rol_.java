package com.mycompany.logic;

import com.mycompany.logic.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T13:58:36", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-28T22:34:47", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> 020dcfe9f96ea23574fa2a92cbc843cf9df76c26
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-28T23:00:31", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> 38a889aa182ea29eeb4bbfae38339f16423da9d6
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> name;
    public static volatile SingularAttribute<Rol, String> description;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile ListAttribute<Rol, User> users;

}