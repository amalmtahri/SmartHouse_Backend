package com.app.smarthouse.service;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.repository.FloorRepository;
import com.app.smarthouse.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;


    public List<Floor> getAll(){
        return floorRepository.findAll();
    }

    public Floor addFloor(Floor floor){
        return floorRepository.save(floor);
    }

    public Floor getOne(String id){
        return floorRepository.findById(id).orElse(null);
    }

    public Floor updateFloor(Floor floor){
        Floor floor1 = floorRepository.findById(floor.getId()).orElse(null);
        if(floor1 != null){
            return floorRepository.save(floor);
        }
        return null;
    }

    public String deleteFloor(String id) {
        floorRepository.deleteById(id);
        return "Floor removed !!";
    }
}
