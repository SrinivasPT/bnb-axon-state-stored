package com.edge.bnb.command.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ContactDto {
    UUID id;
    String firstName;
    String lastName;
    String typeCode;
    String imageUrl;
    List<AddressDto> addressDto;
}
