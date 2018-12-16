package com.onlineInterview.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
