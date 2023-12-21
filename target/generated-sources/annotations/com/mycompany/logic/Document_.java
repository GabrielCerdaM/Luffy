package com.mycompany.logic;

import com.mycompany.logic.Sale;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-20T19:50:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, LocalDateTime> createdAt;
    public static volatile SingularAttribute<Document, String> extension;
    public static volatile SingularAttribute<Document, Sale> sale;
    public static volatile SingularAttribute<Document, LocalDateTime> deletedAt;
    public static volatile SingularAttribute<Document, String> name;
    public static volatile SingularAttribute<Document, String> location;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, LocalDateTime> updatedAt;

}