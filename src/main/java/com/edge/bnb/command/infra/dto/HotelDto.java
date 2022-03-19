package com.edge.bnb.command.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class HotelDto {
    UUID id;

    @NotNull(message = "Name cannot be null")
    String name;

    @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
    String description;

    @NotEmpty(message = "Contacts cannot be empty")
    List<ContactDto> contactDto;
}
