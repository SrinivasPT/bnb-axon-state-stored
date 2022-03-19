package com.edge.bnb.query.application.mapper;

import com.edge.bnb.shared.event.HotelCreatedEvent;
import com.edge.bnb.query.model.Hotel;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface QuerySideHotelMapper {
    @Mapping(source = "contacts", target = "contacts")
    Hotel toEntity(HotelCreatedEvent event);
}
