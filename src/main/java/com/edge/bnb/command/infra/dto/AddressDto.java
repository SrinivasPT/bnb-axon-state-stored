package com.edge.bnb.command.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AddressDto {
    private UUID id;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String country;
    private String typeCode;
}
