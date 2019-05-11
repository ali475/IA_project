package com.onlineInterview.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Interview;

public interface InterviewRepository extends CrudRepository<Interview, Integer>{

}
