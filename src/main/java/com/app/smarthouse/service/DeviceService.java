package com.app.smarthouse.service;

import com.app.smarthouse.model.Device;
import com.app.smarthouse.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    public List<Device> getAll(){
        return deviceRepository.findAll();
    }

    public Device addDevice(Device device){
        return deviceRepository.save(device);
    }

    public Device getOne(String id){
        return deviceRepository.findById(id).orElse(null);
    }

    public Device updateDevice(Device device){
        Device device1 = deviceRepository.findById(device.getId()).orElse(null);
        if(device1 != null){
            return deviceRepository.save(device);
        }
        return null;
    }

    public String deleteDevice(String id) {
        deviceRepository.deleteById(id);
        return "Device removed !!";
    }
}
