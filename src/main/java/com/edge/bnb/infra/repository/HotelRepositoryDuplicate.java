package com.edge.bnb.infra.repository;

import com.edge.bnb.domain.aggregate.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepositoryDuplicate extends JpaRepository<Hotel, String> {
}
