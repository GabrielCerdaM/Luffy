package com.mycompany.logic;

import com.mycompany.logic.Client;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-07T23:46:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, LocalDateTime> createdAt;
    public static volatile SingularAttribute<Document, String> extension;
    public static volatile SingularAttribute<Document, LocalDateTime> deletedAt;
    public static volatile SingularAttribute<Document, String> name;
    public static volatile SingularAttribute<Document, Client> client;
    public static volatile SingularAttribute<Document, String> location;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, LocalDateTime> updatedAt;

}