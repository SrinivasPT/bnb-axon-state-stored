package com.edge.bnb.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class UpdateHotelNameCommand {
    @TargetAggregateIdentifier
    String id;
    String name;
    String description;
}
