package com.edge.bnb.domain.command;

import com.edge.bnb.domain.command.common.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateHotelCommand {
    @TargetAggregateIdentifier
    String id;
    String name;
    String description;
    List<Address> addresses = new ArrayList<>();
}
