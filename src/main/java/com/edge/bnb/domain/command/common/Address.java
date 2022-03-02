package com.edge.bnb.domain.command.common;

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
