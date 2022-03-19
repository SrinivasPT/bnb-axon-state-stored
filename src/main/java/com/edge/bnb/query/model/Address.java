package com.edge.bnb.query.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @Type(type = "uuid-char") // Note: Without this, it treats the UUID as string and insert fails
    private UUID id;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String country;
    private String typeCode;
}
