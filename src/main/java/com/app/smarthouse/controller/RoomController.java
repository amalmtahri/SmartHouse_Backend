package com.app.smarthouse.controller;

import com.app.smarthouse.model.Room;
import com.app.smarthouse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Room>> getAll(){
        return ResponseEntity.ok(roomService.getAll());
    }

    @PostMapping("/add")
    public Room add(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @GetMapping("/getOne")
    public Room getOne(@PathVariable String id){return roomService.getOne(id);}

    @PutMapping("/update")
    public Room update(@RequestBody Room room){ return roomService.updateRoom(room);}

    @DeleteMapping("/delete")
    public String delete(String id){
        return roomService.deleteRoom(id);
    }
}
