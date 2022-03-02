package com.edge.bnb.application.mapper;

import com.edge.bnb.domain.command.CreateHotelCommand;
import com.edge.bnb.domain.aggregate.Hotel;
import com.edge.bnb.domain.event.HotelCreatedEvent;
import com.edge.bnb.infra.dto.HotelRequestData;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface HotelMapper {

    @Mapping(source = "addresses", target = "addresses")
    CreateHotelCommand toCommand(HotelRequestData dto);

    @Mapping(source = "addresses", target = "addresses")
    Hotel toEntity(CreateHotelCommand command);

    @Mapping(source = "addresses", target = "addresses")
    HotelCreatedEvent toEvent(CreateHotelCommand command);
}
