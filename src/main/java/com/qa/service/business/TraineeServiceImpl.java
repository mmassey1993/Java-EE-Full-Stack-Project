package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.service.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService{

	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);

	@Inject
	private TraineeRepository repo;

	public String getAllTrainees() {
		LOGGER.info("In TraineeServiceImpl getAllAccounts ");
		return repo.getAllTrainees();
	}

	@Override
	public String addTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	@Override
	public String updateTrainee(Long id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);

	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}
}
