package com.edge.bnb.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String id;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String country;
}
