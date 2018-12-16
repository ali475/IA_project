package com.onlineInterview.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

}
