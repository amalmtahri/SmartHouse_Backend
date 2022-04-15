package com.app.smarthouse.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Builder
@Getter
@Setter
public class House {

    @Id
    private String id;
    private String name;
    private String address;
    @DBRef
    private Collection<Floor> floors;
    @DBRef
    private User user;

    public House() {
    }
}