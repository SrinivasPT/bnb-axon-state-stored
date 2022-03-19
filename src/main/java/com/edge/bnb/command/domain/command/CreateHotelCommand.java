package com.edge.bnb.command.domain.command;

import com.edge.bnb.command.domain.command.common.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateHotelCommand {
    @TargetAggregateIdentifier
    UUID id;
    String name;
    String description;
    List<Contact> contacts = new ArrayList<>();
}
