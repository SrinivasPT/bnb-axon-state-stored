package com.edge.bnb.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class HotelRequestData {
    Long id;

    @NotNull(message = "Name cannot be null")
    String name;

    @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
    String description;

    @NotEmpty(message = "Address cannot be empty")
    List<Address> addresses;
}
