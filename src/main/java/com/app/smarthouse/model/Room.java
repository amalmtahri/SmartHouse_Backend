package com.app.smarthouse.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Builder
@Getter
@Setter
public class Room {

    @Id
    private String id;
    private Long number;
    @DBRef
    private Collection<Device> devices;
    @DBRef
    private Floor floor;
}