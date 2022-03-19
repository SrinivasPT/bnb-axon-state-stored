package com.edge.bnb.command.domain.command;

import com.edge.bnb.command.domain.command.common.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateContactCommand {
    private UUID id;
    private String firstName;
    private String lastName;
    private String typeCode;
    private String imageUrl;
    List<Address> addresses = new ArrayList<>();
}
