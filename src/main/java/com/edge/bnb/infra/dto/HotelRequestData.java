package com.edge.bnb.infra.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HotelRequestData {
    Long id;
    String name;
    String description;
    List<Address> addresses = new ArrayList<>();
}
