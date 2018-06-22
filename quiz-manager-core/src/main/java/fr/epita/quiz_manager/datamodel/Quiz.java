package fr.epita.quiz_manager.datamodel;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToMany
	private Set<Question> questionList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}

	public Integer getId() {
		return id;
	}
	
	
	
}
