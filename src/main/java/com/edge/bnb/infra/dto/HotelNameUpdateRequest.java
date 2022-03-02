package com.edge.bnb.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelNameUpdateRequest {
    String id;
    String name;
    String description;
}
