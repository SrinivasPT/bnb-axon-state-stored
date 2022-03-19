package com.edge.bnb.shared.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class HotelNameUpdatedEvent {
    UUID id;
    String name;
    String description;
}
