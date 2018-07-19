package com.qa.service.repository;

public interface TraineeRepository {

	String getAllTrainees();

	String createTrainee(String trainee);

	String updateTrainee(Long id, String traineeToUpdate);

	String deleteTrainee(Long id);

}