package com.mycompany.logic;

import com.mycompany.logic.Client;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-07T19:37:18", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, LocalDateTime> createdAt;
    public static volatile SingularAttribute<Payment, Integer> amount;
    public static volatile SingularAttribute<Payment, LocalDateTime> deletedAt;
    public static volatile SingularAttribute<Payment, Client> client;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, LocalDateTime> updatedAt;

}