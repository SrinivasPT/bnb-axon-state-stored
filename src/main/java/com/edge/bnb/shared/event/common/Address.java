package com.edge.bnb.shared.event.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Address {
    private UUID id;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String country;
    private String typeCode;
}
