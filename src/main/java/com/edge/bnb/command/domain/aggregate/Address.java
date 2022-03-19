package com.edge.bnb.command.domain.aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.EntityId;

import javax.persistence.GeneratedValue;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Address {
    @EntityId
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String country;
    private String typeCode; // Primary & Secondary
}
