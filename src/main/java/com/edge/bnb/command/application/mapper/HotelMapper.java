package com.edge.bnb.command.application.mapper;

import com.edge.bnb.command.domain.aggregate.Hotel;
import com.edge.bnb.command.domain.command.common.Contact;
import com.edge.bnb.command.domain.command.CreateHotelCommand;
import com.edge.bnb.shared.event.HotelCreatedEvent;
import com.edge.bnb.command.infra.dto.ContactDto;
import com.edge.bnb.command.infra.dto.HotelDto;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface HotelMapper {
    @Mapping(source = "contactDto", target = "contacts")
    CreateHotelCommand toCommand(HotelDto dto);

    @Mapping(source = "addressDto", target = "addresses")
    Contact toCommand(ContactDto value);

    @Mapping(source = "contacts", target = "contacts")
    Hotel toEntity(CreateHotelCommand cmd);

    @Mapping(source = "contacts", target = "contacts")
    Hotel toEntity(HotelCreatedEvent event, @MappingTarget Hotel hotel);

    @Mapping(source = "addresses", target = "addresses")
    com.edge.bnb.command.domain.aggregate.Contact toEntity(com.edge.bnb.shared.event.common.Contact contact);

    @Mapping(source = "contacts", target = "contacts")
    HotelCreatedEvent toEvent(CreateHotelCommand command);

    @Mapping(source = "addresses", target = "addresses")
    com.edge.bnb.shared.event.common.Contact toEvent(Contact contact);
}
