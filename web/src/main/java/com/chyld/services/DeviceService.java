package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {
    private IDeviceRepository repository;

    @Autowired
    public void setRepository(IDeviceRepository repository) {
        this.repository = repository;
    }

    public Run findActiveRun(Device d){
        Optional<Run> run = d.getRuns().stream().filter(r -> r.getStopTime() == null).findFirst();
        if (run.isPresent()){
            return run.get();
        }

        return null;
    }
    public Device findDeviceById(Integer id) {
        return repository.findOne(id);
    }

    public Device saveDevice (Device d){
        return repository.save(d);
    }

    public Device findDeviceBySerialNumber(String sn) {
        return repository.findBySerialNumber(sn);
    }
}
