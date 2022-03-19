package com.edge.bnb.query.infra.repository;

import com.edge.bnb.query.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QueryRepository extends JpaRepository<Hotel, UUID> {
}
