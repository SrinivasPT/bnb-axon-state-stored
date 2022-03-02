//package com.example.axon.inventory.application;
//
//import com.example.axon.inventory.application.mapper.HotelMapper;
//import com.example.axon.inventory.domain.aggregate.Hotel;
//import com.example.axon.inventory.domain.command.CreateHotelCommand;
//import com.example.axon.inventory.infra.repository.HotelRepositoryDuplicate;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.eventhandling.gateway.EventGateway;
//import org.mapstruct.factory.Mappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Component
//public class CreateHotelCommandHandler {
//    @Autowired
//    private HotelRepositoryDuplicate repository;
//
//    @Autowired
//    private EventGateway eventGateway;
//
//    private final HotelMapper mapper = Mappers.getMapper(HotelMapper.class);
//
//    @CommandHandler
//    public String createRoom(CreateHotelCommand command) {
//        // Hotel hotel = new Hotel(command);
//        // hotel = repository.save(hotel);
//        // hotel.handle(command);
//        Hotel hotel = mapper.toEntity(command);
//        eventGateway.publish(mapper.toEvent(command));
//        return hotel.getId();
//    }
//}
