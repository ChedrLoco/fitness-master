package com.chyld.services;


import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.repositories.IPositionRepository;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    private IPositionRepository repository;

    @Autowired
    public void setRepository(IPositionRepository repository) {
        this.repository = repository;
    }

    public Position savePosition (Position p){
        return repository.save(p);
    }

}
