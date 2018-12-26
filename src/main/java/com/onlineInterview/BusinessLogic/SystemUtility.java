package com.onlineInterview.BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Position;
import com.onlineInterview.Entities.Question;
import com.onlineInterview.Entities.Topic;
import com.onlineInterview.Repositories.PositionRepository;
import com.onlineInterview.Repositories.QuestionRepository;
import com.onlineInterview.Repositories.TopicRepository;

@Service
public class SystemUtility {

	@Autowired
	PositionRepository posRepo;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	TopicRepository T_repository;
	
	public SystemUtility() {}
	
	public HttpSession getUserSession(HttpServletRequest request) {
		if(request.getSession(false) != null){
		    return request.getSession();
		}
		return null;
	}
	
	public List<Candidate> getPositionApplicants(String posName){
		Position pos = posRepo.findById(posName).get();
		Set<Candidate> cans = pos.getCandidates();
		List<Candidate> candidates = new ArrayList<>();
		for (Candidate c : cans) {candidates.add(c);}
		
		return candidates;
	}
	
	public List<Position> getPositions(){
		Iterable<Position> ps = posRepo.findAll();
		List<Position> listPositions = new ArrayList<>();
		for (Position p : ps) {listPositions.add(p);}
		return listPositions;
	}
	
	public Position getPositionByName(String pName){
		return posRepo.findById(pName).get();
	}
	
	public ArrayList<Question> get_questions(String question_name,int number_of_questions) {
		Topic currnt_topic = T_repository.findById(question_name).get();
		Set<Question>questions=currnt_topic.getQuestions();
		ArrayList<Question> temp = new ArrayList<>();
		for (Question q : questions) {temp.add(q);}
		Random rand = new Random ();
		ArrayList<Question> result= new ArrayList<>();
		for (int i = 0; i < number_of_questions; i++) {
			int x = rand.nextInt(temp.size());
			result.add(temp.get(x));
			temp.remove(x);
		}
		return result;
		
	}

}
