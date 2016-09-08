package com.chyld.repositories;


import com.chyld.entities.Position;
import com.chyld.entities.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPositionRepository extends PagingAndSortingRepository<Position, Integer> {
}
