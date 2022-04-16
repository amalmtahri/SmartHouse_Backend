package com.app.smarthouse.service;

import com.app.smarthouse.model.Room;
import com.app.smarthouse.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public Room getOne(String id){
        return roomRepository.findById(id).orElse(null);
    }

    public Room updateRoom(Room room){
        Room room1 = roomRepository.findById(room.getId()).orElse(null);
        if(room1 != null){
            return roomRepository.save(room);
        }
        return null;
    }

    public String deleteRoom(String id) {
        roomRepository.deleteById(id);
        return "Room removed !!";
    }
}
