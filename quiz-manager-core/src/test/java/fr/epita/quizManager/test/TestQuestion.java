package fr.epita.quizManager.test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.QuestionType;
import fr.epita.quiz_manager.services.MCQChoiceDAO;
import fr.epita.quiz_manager.services.QuestionDAO;
import fr.epita.quiz_manager.services.QuestionOperationsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestQuestion {
	@Inject
	QuestionOperationsService questionService;
	
	@Before
	public void setup() {
		
		for(int i = 1; i <= 5; i++) {
			Question question = new Question();
			question.setTitle("question " + i);
			question.setType(QuestionType.MCQ);
			
			MCQChoice choice = new MCQChoice();
			choice.setCorrect(true);
			choice.setChoice("ans1");
			choice.setQuestion(question);
			
			MCQChoice choice2 = new MCQChoice();
			choice2.setCorrect(false);
			choice2.setChoice("ans2");
			choice2.setQuestion(question);
			
			List<MCQChoice> answers = new ArrayList<>();
			answers.add(choice);
			answers.add(choice2);
			
			questionService.createMCQQuestion(question, answers);
		}
		
		
	}
	
	@Test
	public void testSaveAndSearchQuestion() {
		final Question question = new Question();
		question.setTitle("How to configure Hibernate?");
		question.setType(QuestionType.MCQ);

		
		final MCQChoice choice = new MCQChoice();
		choice.setCorrect(true);
		choice.setChoice("thanks to a LocalSessionFactoryBean instance");
		choice.setQuestion(question);
		
		final MCQChoice choice2 = new MCQChoice();
		choice2.setCorrect(false);
		choice2.setChoice("Praying in honor of lord Cthulhu");
		choice2.setQuestion(question);
		
		
		final List<MCQChoice> possibleAnswers= new ArrayList<>();
		possibleAnswers.add(choice);
		possibleAnswers.add(choice2);
		questionService.createMCQQuestion(question, possibleAnswers);
		
		Assert.assertTrue(questionService.search(question).size() == 1);
		Assert.assertEquals(2, questionService.searchMCQChoices(question).size());
	}
	
	@Test
	public void testSearchAllQuestions() {
		List<Question> allQuestions = questionService.search(new Question());
		Assert.assertEquals(5, allQuestions.size());
	}
	
	@Test
	public void testDeleteQuestion() {
		List<Question> allQuestions = questionService.search(new Question());
		questionService.deleteMCQQuestion(allQuestions.get(0));
		allQuestions = questionService.search(new Question());
		Assert.assertEquals(4, allQuestions.size());
	}
	
	@Test
	public void testUpdateQuestion() {
		List<Question> allQuestions = questionService.search(new Question());
		Question selectedQuestion = allQuestions.get(0);
		Integer questionId = selectedQuestion.getId();
		List<MCQChoice> questionAnswers = questionService.searchMCQChoices(selectedQuestion);
		int answersSize = questionAnswers.size();
		selectedQuestion.setTitle("other name");
		questionAnswers.remove(0);
		questionService.updateMCQQuestion(selectedQuestion, questionAnswers);
		
		Question criteria = new Question();
		criteria.setId(questionId);
		Question updatedQuestion = questionService.search(criteria).get(0);
		
		Assert.assertEquals("other name", updatedQuestion.getTitle());
		Assert.assertEquals(answersSize - 1, questionService.searchMCQChoices(updatedQuestion).size());
	}
	@After
	public void tearDown() {
		List<Question> allQuestions = questionService.search(new Question());
		for(Question q : allQuestions) {
			questionService.deleteMCQQuestion(q);
		}
	}

}
