package com.edge.bnb.command.domain.aggregate;

import com.edge.bnb.command.application.mapper.HotelMapper;
import com.edge.bnb.command.domain.command.CreateHotelCommand;
import com.edge.bnb.command.domain.command.UpdateHotelNameCommand;
import com.edge.bnb.shared.event.HotelCreatedEvent;
import com.edge.bnb.shared.event.HotelNameUpdatedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.mapstruct.factory.Mappers;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Data
@Aggregate
public class Hotel {
    @AggregateIdentifier
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String description;
    private Integer version;

    @AggregateMember
    private final List<Contact> contacts = new ArrayList<>();

    public Hotel() {
    }

    @CommandHandler
    public Hotel(CreateHotelCommand command) {
        HotelCreatedEvent event =Mappers.getMapper(HotelMapper.class).toEvent(command);
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateHotelNameCommand command) {
        apply(new HotelNameUpdatedEvent(command.getId(), command.getName(), command.getDescription()));
    }

    @EventSourcingHandler
    public void on(HotelCreatedEvent event) {
        Mappers.getMapper(HotelMapper.class).toEntity(event, this);
    }

    @EventSourcingHandler
    public void on(HotelNameUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }
}
