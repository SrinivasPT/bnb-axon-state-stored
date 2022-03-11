package com.edge.bnb.infra.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Handling missing fields is yet to be figured out. One way to handle this is
 * 1) If we add the @RequiredArgsConstructor, and @NonNull, then it throws exception and fails the case.
 * So we can't use it as test case. Also we are ending up using both @NonNull and @NotNull which is not decent
 */
@Data
@RequiredArgsConstructor
public class HotelNameUpdateRequest {
    @NonNull @NotNull(message = "ID is mandatory")
    String id;

    @NonNull @NotNull(message = "Name is mandatory")
    String name;

    String description;
}
