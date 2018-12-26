package com.onlineInterview.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	@Query("SELECT DISTINCT t.examType FROM Topic t")
	List<String> findExamTypes();

}
