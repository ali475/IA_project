package com.onlineInterview.BusinessLogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Interview;
import com.onlineInterview.Entities.Position;
import com.onlineInterview.Entities.Question;
import com.onlineInterview.Entities.Topic;
import com.onlineInterview.Entities.UserExam;
import com.onlineInterview.Entities.UserExamQuestion;
import com.onlineInterview.Repositories.InterviewRepository;
import com.onlineInterview.Repositories.PositionRepository;
import com.onlineInterview.Repositories.QuestionRepository;
import com.onlineInterview.Repositories.TopicRepository;
import com.onlineInterview.Repositories.UserExamQuestionRepository;
import com.onlineInterview.Repositories.UserExamRepository;

@Service
public class SystemUtility {

	@Autowired
	PositionRepository posRepo;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	TopicRepository T_repository;
	@Autowired
	InterviewRepository IVRepo;
	@Autowired
	UserExamRepository ExamRepo;
	@Autowired
	UserExamQuestionRepository UEQRepo;
	public SystemUtility() {}
	
	public HttpSession getUserSession(HttpServletRequest request) {
		if(request.getSession(false) != null){
		    return request.getSession();
		}
		return null;
	}
	
	public List<String> getExamTypes(){return T_repository.findExamTypes();}
	
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

	public List<UserExam> getIvExams(int iv_id) {
		Interview current_interview= IVRepo.findById(iv_id).get();
		Set<UserExam> currernt_userExams = current_interview.getUserExams();
		List<UserExam> returned_Exams = new ArrayList<>();
		for (UserExam e:currernt_userExams) {returned_Exams.add(e);}
		return returned_Exams;
	}

	public List<UserExamQuestion> getUserExamQuestions(int userExamId) {
		UserExam Exam = ExamRepo.findById(userExamId).get();
		List<UserExamQuestion> returned_UserExamQuestion = new ArrayList<>();
		if (Exam.getUserExamQuestions().size()!=0) {
		for (UserExamQuestion q : Exam.getUserExamQuestions()) {returned_UserExamQuestion.add(q);}	
		}
		else {
			returned_UserExamQuestion = createUserExamQuestions(userExamId);
		}
		
		return returned_UserExamQuestion;
	}

	private List<UserExamQuestion> createUserExamQuestions(int userExamId) {
		UserExam exam = ExamRepo.findById(userExamId).get();
		Iterable <Topic> _Topics = T_repository.findAll();
		List<Question>Questions = new ArrayList<>();
		for(Topic t :_Topics) {
			for(Question q :t.getQuestions()) {
				Questions.add(q);
			}
		}
		List<Question>randomQestions = GetRamdomQestions(Questions,exam.getNumOfQuestions());
		List<UserExamQuestion> returned = new ArrayList<>();
		for (int i = 0; i < exam.getNumOfQuestions(); i++) {
			UserExamQuestion temp = new UserExamQuestion(exam,randomQestions.get(i));
			returned.add(temp);
			UEQRepo.save(temp);
			
		}
		return returned;
	}

	private List<Question> GetRamdomQestions(List<Question> questions, int numOfQuestions) {
		Random rand = new Random();
		List<Question>randomQestions = new ArrayList<>();
		for (int i = 0; i < numOfQuestions; i++) {
			System.out.println("");
			//int index = rand.nextInt(questions.size());
			randomQestions.add(questions.get(i));
			//questions.remove(i);
			
		}
		return randomQestions;
	}

	

}
