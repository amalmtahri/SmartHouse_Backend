package com.app.smarthouse.service.impl;

import com.app.smarthouse.enums.Status;
import com.app.smarthouse.model.Device;
import com.app.smarthouse.model.Floor;
import com.app.smarthouse.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class DeviceServiceTest {

    @InjectMocks
    private DeviceService deviceService;

    @Mock
    private DeviceRepository deviceRepository;

    @Test
    void getAll() {
        Device device1 = new Device("12OZUEIEII", Status.ON,"Lamp",null);
        Device device2 = new Device("12OZUEIEII", Status.OFF,"TV",null);
        List<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);
        given(deviceRepository.findAll()).willReturn(devices);
        List<Device> devices1 = deviceService.getAll();
        assertEquals(devices, devices1);
        //to verify
        verify(deviceRepository).findAll();

    }

    @Test
    void addDevice() {
    }

    @Test
    void getOne() {
    }

    @Test
    void updateDevice() {
    }

    @Test
    void deleteDevice() {
    }
}