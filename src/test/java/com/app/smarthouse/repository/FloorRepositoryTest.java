package com.app.smarthouse.repository;

import com.app.smarthouse.model.Floor;
import org.junit.jupiter.api.Disabled;
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

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class FloorRepositoryTest {

    @Mock
    private FloorRepository floorRepository;

    @Test
    void getAll() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Floor floor2 = new Floor("12OZUEIEII", 2L,null,null);
        List<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);
        Mockito.when(floorRepository.findAll()).thenReturn(floors);
        assertThat(floorRepository.findAll()).isNotNull();
    }

    @Test
    void add() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Mockito.when(floorRepository.save(floor1))
                .thenReturn(floor1);
        assertThat(floorRepository.save(floor1)).isEqualTo(floor1);
    }

    @Test
    @Disabled
    void delete() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        floorRepository.deleteById(floor1.getId());
        assertThat(floorRepository.findById(floor1.getId())).isNotNull();
    }

    @Test
    void findById() {
        Floor floor1 = new Floor("12OZUEIEII", 1L,null,null);
        Mockito.when(floorRepository.findById(floor1.getId())).thenReturn(Optional.of(floor1));
        assertThat(floorRepository.findById(floor1.getId())).isNotNull();
    }

}