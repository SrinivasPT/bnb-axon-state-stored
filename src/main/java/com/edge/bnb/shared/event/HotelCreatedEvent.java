package com.edge.bnb.shared.event;

import com.edge.bnb.shared.event.common.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class HotelCreatedEvent {
    private UUID id;
    private String name;
    private String description;
    private Integer version;
    private List<Contact> contacts = new ArrayList<>();
}
