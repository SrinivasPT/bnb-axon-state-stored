package com.edge.bnb.query.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor
public class Hotel {
    @Id
    @Type(type = "uuid-char") // Note: Without this, it treats the UUID as string and insert fails
    private UUID id;
    private String name;
    private String description;
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private final List<Contact> contacts = new ArrayList<>();
}
