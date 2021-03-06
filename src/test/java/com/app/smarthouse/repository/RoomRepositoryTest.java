package com.app.smarthouse.repository;

import com.app.smarthouse.model.Floor;
import com.app.smarthouse.model.House;
import com.app.smarthouse.model.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class RoomRepositoryTest {


    @Mock
    private RoomRepository roomRepository;

    @Test
    void getAll() {
        Room room1 = new Room("12OZUEIEII",2L,null,null);
        Room room2 = new Room("ZERT456",7L,null,null);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        Mockito.when(roomRepository.findAll()).thenReturn(rooms);
        assertThat(roomRepository.findAll()).isNotNull();
    }

    @Test
    void add() {
        Room room2 = new Room("ZERT456",7L,null,null);
        Mockito.when(roomRepository.save(room2))
                .thenReturn(room2);
        assertThat(roomRepository.save(room2)).isEqualTo(room2);
    }

    @Test
    void findById() {
        Room room2 = new Room("ZERT456",7L,null,null);
        Mockito.when(roomRepository.findById(room2.getId())).thenReturn(Optional.of(room2));
        assertThat(roomRepository.findById(room2.getId())).isNotNull();
    }
}