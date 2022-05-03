package com.app.smarthouse.repository;

import com.app.smarthouse.enums.Status;
import com.app.smarthouse.model.Device;
import com.app.smarthouse.model.Floor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class DeviceRepositoryTest {

    @Mock
    private DeviceRepository deviceRepository;

    @Test
    void getAll() {
        Device device1 = new Device("12OZUEIEII", Status.ON,"Lamp",null);
        Device device2 = new Device("12OZUEIEII", Status.OFF,"TV",null);
        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);
        Mockito.when(deviceRepository.findAll()).thenReturn(devices);
        assertThat(deviceRepository.findAll()).isNotNull();
    }
}