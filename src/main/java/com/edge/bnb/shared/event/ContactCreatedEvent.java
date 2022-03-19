package com.edge.bnb.shared.event;

import com.edge.bnb.shared.event.common.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ContactCreatedEvent {
    private UUID id;
    private String firstName;
    private String lastName;
    private String typeCode;
    List<Contact> contacts;
}
