package com.onlineInterview.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineInterview.Entities.Position;
import com.onlineInterview.Repositories.PositionRepository;

public class SystemUtility {

	@Autowired
	PositionRepository posRepo;
	
	public SystemUtility() {}
	
	public List<Position> getPositions(){
		Iterable<Position> ps = posRepo.findAll();
		List<Position> listPositions = new ArrayList<>();
		for (Position p : ps) {listPositions.add(p);}
		return listPositions;
	}

}
