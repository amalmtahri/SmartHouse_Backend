package com.app.smarthouse.controller;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floor")
public class FloorController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Floor>> getAll(){
        return ResponseEntity.ok(floorService.getAll());
    }

    @PostMapping("/add")
    public Floor add(@RequestBody Floor floor){
        return floorService.addFloor(floor);
    }

    @GetMapping("/getOne")
    public Floor getOne(@PathVariable String id){return floorService.getOne(id);}

    @PutMapping("/update")
    public Floor update(@RequestBody Floor floor){
        return floorService.updateFloor(floor);
    }

    @DeleteMapping("/delete")
    public String delete(String id){
        return floorService.deleteFloor(id);
    }
}