package com.onlineInterview.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
