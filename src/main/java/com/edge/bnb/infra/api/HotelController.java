package com.edge.bnb.infra.api;

import com.edge.bnb.application.mapper.HotelMapper;
import com.edge.bnb.infra.dto.HotelRequestData;
import com.edge.bnb.domain.command.UpdateHotelNameCommand;
import com.edge.bnb.infra.dto.HotelNameUpdateRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public CompletableFuture<Integer> createRoom(@RequestBody @Valid HotelRequestData dto) {
        return commandGateway.send(mapper.toCommand(dto));
    }

    @PostMapping(path = "/update-name")
    public CompletableFuture<Integer> updateName(@RequestBody HotelNameUpdateRequest dto) {
        return commandGateway.send(new UpdateHotelNameCommand(dto.getId(), dto.getName(), dto.getDescription()));
    }
}
