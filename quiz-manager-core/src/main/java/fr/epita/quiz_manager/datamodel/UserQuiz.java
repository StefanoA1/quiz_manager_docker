package fr.epita.quiz_manager.datamodel;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private User user;
	
	private ArrayList<MCQChoice> answers;
	@ManyToOne
	private Quiz quiz;
}
