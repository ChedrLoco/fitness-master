package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunService {
    private IRunRepository repository;

    @Autowired
    public void setRepository(IRunRepository repository) {
        this.repository = repository;
    }

    public Run saveRun (Run d){
        return repository.save(d);
    }


}
