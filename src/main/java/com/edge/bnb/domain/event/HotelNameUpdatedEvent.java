package com.edge.bnb.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelNameUpdatedEvent {
    String id;
    String name;
    String description;
}
