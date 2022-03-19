package com.edge.bnb.shared.event.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Contact {
    private UUID id;
    private String firstName;
    private String lastName;
    private String typeCode;
    private String imageUrl;
    List<Address> addresses;
}
