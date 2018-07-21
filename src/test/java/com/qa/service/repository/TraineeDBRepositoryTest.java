package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.domain.Subject;
import com.qa.domain.Trainee;
import com.qa.service.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBRepositoryTest {

	@InjectMocks
	private TraineeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"name\":\"Charlie Charlies\",\"subjects\":[]}]";

	private static final String MOCK_OBJECT = "{\"name\":\"Charlie Charlies\",\"subjects\":[]}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllAccounts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		List<Subject> subjects = new ArrayList<Subject>();
		trainees.add(new Trainee("Charlie Charlies", subjects));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}

	@Test
	public void testCreateAccount() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"trainee successfully added\"}");
	}

	@Test
	public void testUpdateAccount() {
		String reply = repo.updateTrainee(1L, MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"trainee successfully updated\"}");
	}

	@Test
	public void testDeleteAccount() {
		String reply = repo.deleteTrainee(1L);
		Assert.assertEquals(reply, "{\"message\": \"trainee successfully deleted\"}");
	}

}
