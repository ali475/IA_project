package com.onlineInterview.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.onlineInterview.Entities.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, String> {
	
	boolean existsByEmail(String email);
	
}
