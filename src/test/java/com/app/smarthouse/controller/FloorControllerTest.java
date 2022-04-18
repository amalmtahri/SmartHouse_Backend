package com.app.smarthouse.controller;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.service.impl.FloorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FloorController.class)
class FloorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FloorService floorService;

    @Test
    void getAll() throws Exception {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null);
        Floor floor2 = new Floor("12OZUEIEII", 2L,null);
        List<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);
        when(floorService.getAll()).thenReturn(floors);
        mockMvc.perform(get("/api/floor/getAll"))
                .andExpect(status().isOk());

    }

    @Test
    void add() {
    }

    @Test
    void getOne() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}