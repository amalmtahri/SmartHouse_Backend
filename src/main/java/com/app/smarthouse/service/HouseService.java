package com.app.smarthouse.service;

import com.app.smarthouse.model.House;
import com.app.smarthouse.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;



    public List<House> getAll(){
        return houseRepository.findAll();
    }

    public House addHouse(House house){
        return houseRepository.save(house);
    }

    public House getOne(String id){
        return houseRepository.findById(id).orElse(null);
    }

    public House updateHouse(House house){
        House house1 = houseRepository.findById(house.getId()).orElse(null);
        if(house1 != null){
           return houseRepository.save(house);
        }
        return null;
    }

    public String deleteHouse(String id) {
        houseRepository.deleteById(id);
        return "House removed !!";
    }
}
