package com.edge.bnb.domain.aggregate;

import com.edge.bnb.application.mapper.HotelMapper;
import com.edge.bnb.domain.command.CreateHotelCommand;
import com.edge.bnb.domain.event.HotelNameUpdatedEvent;
import com.edge.bnb.domain.command.UpdateHotelNameCommand;
import com.edge.bnb.domain.event.HotelCreatedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.mapstruct.factory.Mappers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Entity
@Aggregate
@Data
public class Hotel {
    @Id
    @AggregateIdentifier
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;

    @AggregateMember
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private final List<Address> addresses = new ArrayList<>();

    public Hotel() {
    }

    @CommandHandler
    public Hotel(CreateHotelCommand command) {
        apply(Mappers.getMapper(HotelMapper.class).toEvent(command));
    }

    // TODO: This hotel need to be moved to Service as we will get the ID only after the hotel is stored?
    public void handle(CreateHotelCommand command) {
        apply(Mappers.getMapper(HotelMapper.class).toEvent(command));
    }

    @CommandHandler
    void handle(UpdateHotelNameCommand command) {
        apply(new HotelNameUpdatedEvent(command.getId(), command.getName(), command.getDescription()));
    }

    @EventSourcingHandler
    void on(HotelCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();

        event.getAddresses().forEach(eAddress -> {
            Address address = new Address(
                    eAddress.getId(), eAddress.getAddressLineOne(), eAddress.getAddressLineTwo(),
                    eAddress.getCity(), eAddress.getCountry());
            this.addresses.add(address);
        });
    }

    @EventSourcingHandler
    void on(HotelNameUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }
}