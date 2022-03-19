package com.edge.bnb.query.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Contact {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private final List<Address> addresses = new ArrayList<>();
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String firstName;
    private String lastName;
    private String typeCode;
    private String imageUrl;
}
