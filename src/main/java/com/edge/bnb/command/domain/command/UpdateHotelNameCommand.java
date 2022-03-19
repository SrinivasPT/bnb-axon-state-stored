package com.edge.bnb.command.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateHotelNameCommand {
    @TargetAggregateIdentifier
    UUID id;
    String name;
    String description;
}
