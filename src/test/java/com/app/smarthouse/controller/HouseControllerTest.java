package com.app.smarthouse.controller;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.service.impl.HouseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HouseController.class)
class HouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HouseService houseService;


    @Test
    void getAll() throws Exception {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        House house2 = new House("12OZ456II","HOUSE2","safi",null,null);
        List<House> houses = new ArrayList<>();
       houses.add(house1);
       houses.add(house2);
        when(houseService.getAll()).thenReturn(houses);
        mockMvc.perform(get("/api/house/getAll"))
                .andExpect(status().isOk());

    }

    @Test
    void addHouse() throws Exception {
        House house1 = new House("12OZUEIEII","HOUSE1","safi",null,null);
        when(houseService.addHouse(house1))
                .thenReturn(house1);
        mockMvc.perform(post("/api/house/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(house1)))
                .andExpect(status().isOk());

    }

    @Test
    void getOne() {
    }

    @Test
    void updateHouse() {
    }

    @Test
    void deleteHouse() {
    }
}