package com.edge.bnb.command.domain.aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.modelling.command.EntityId;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Contact {
    @EntityId
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String firstName;
    private String lastName;
    private String typeCode;
    private String imageUrl;

    @AggregateMember
    private final List<Address> addresses = new ArrayList<>();
}
