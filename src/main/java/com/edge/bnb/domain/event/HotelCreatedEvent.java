package com.edge.bnb.domain.event;

import com.edge.bnb.domain.command.common.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class HotelCreatedEvent {
    String id;
    String name;
    String description;
    final List<Address> addresses = new ArrayList<>();
}
