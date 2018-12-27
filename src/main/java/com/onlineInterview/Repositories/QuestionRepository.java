package com.onlineInterview.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Question;
import com.onlineInterview.Entities.Topic;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

	List<Question> findByTopic(Topic t);
	
}
