package com.mycompany.logic;

import com.mycompany.logic.Sale;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-20T02:19:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, LocalDateTime> createdAt;
    public static volatile SingularAttribute<Payment, Integer> amount;
    public static volatile SingularAttribute<Payment, LocalDateTime> deletedAt;
    public static volatile SingularAttribute<Payment, Sale> sale;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, LocalDateTime> updatedAt;

}