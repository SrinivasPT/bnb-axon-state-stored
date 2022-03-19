package com.edge.bnb.command.infra.api;

import com.edge.bnb.command.application.mapper.HotelMapper;
import com.edge.bnb.command.infra.dto.HotelNameUpdateRequest;
import com.edge.bnb.command.infra.dto.HotelDto;
import com.edge.bnb.command.domain.command.UpdateHotelNameCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class HotelController {
    public static final int TIMEOUT_SECONDS = 5;
    private final CommandGateway commandGateway;
    private final HotelMapper mapper = Mappers.getMapper(HotelMapper.class);

    public HotelController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "/hotel")
    public CompletableFuture<Integer> createRoom(@RequestBody @Valid HotelDto dto) {
        populateUUIDs(dto);
        return commandGateway.send(mapper.toCommand(dto));
    }

    private HotelDto populateUUIDs(HotelDto dto) {
        UUID hotelId = dto.getId() == null ? UUID.randomUUID() : dto.getId();
        dto.setId(hotelId);

        // Populated Contact & Address UUID
        dto.getContactDto().forEach(contactDto -> {
            UUID contactId = contactDto.getId() == null ? UUID.randomUUID() : contactDto.getId();
            contactDto.setId(contactId);

            contactDto.getAddressDto().forEach(addressDto -> {
                UUID addressId = addressDto.getId() == null ? UUID.randomUUID() : addressDto.getId();
                addressDto.setId(addressId);
            });
        });

        return dto;
    }

    @PostMapping(path = "/update-name")
    public CompletableFuture<Integer> updateName(@RequestBody HotelNameUpdateRequest dto) {
        return commandGateway.send(new UpdateHotelNameCommand(dto.getId(), dto.getName(), dto.getDescription()));
    }
}
