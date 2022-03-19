package com.edge.bnb.query.application.handler;

import com.edge.bnb.shared.event.HotelCreatedEvent;
import com.edge.bnb.query.application.mapper.QuerySideHotelMapper;
import com.edge.bnb.query.infra.repository.QueryRepository;
import com.edge.bnb.query.model.Hotel;
import com.edge.bnb.shared.event.HotelNameUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelHandler {
    @Autowired
    private QueryRepository queryRepository;

    @EventHandler
    void on(HotelCreatedEvent event) {
        Hotel hotel = Mappers.getMapper(QuerySideHotelMapper.class).toEntity(event);
        queryRepository.save(hotel);
    }

    @EventHandler
    void on(HotelNameUpdatedEvent event) {
        Hotel hotel = this.queryRepository.getById(event.getId());
        hotel.setName(event.getName());
        hotel.setDescription(event.getDescription());
        queryRepository.save(hotel);
    }
}
