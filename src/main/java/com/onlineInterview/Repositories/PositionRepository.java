package com.onlineInterview.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Position;

public interface PositionRepository extends CrudRepository<Position, String> {

}
