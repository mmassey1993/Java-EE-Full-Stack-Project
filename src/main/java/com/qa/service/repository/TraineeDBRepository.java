package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.constants.Constants;
import com.qa.domain.Trainee;
import com.qa.service.business.TraineeService;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {
	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Trainee a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

//	@Override
//	@Transactional(REQUIRED)
//	public String createTrainee(String trainee) {
//		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
//		manager.persist(aTrainee);
//		return Constants.ACCOUNT_ADDED;
//	}
//
//	@Override
//	@Transactional(REQUIRED)
//	public String updateTrainee(Long id, String traineeToUpdate) {
//		LOGGER.info("In traineeDBRepo updatetrainee");
//		Trainee updatedTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
//		Trainee traineeFromDB = findTrainee(id);
//		if (traineeToUpdate != null) {
//			traineeFromDB = updatedTrainee;
//			manager.merge(traineeFromDB);
//		}
//		return Constants.ACCOUNT_UPDATED;
//	}
//
//	@Override
//	@Transactional(REQUIRED)
//	public String deleteTrainee(Long id) {
//		Trainee traineeInDB = findTrainee(id);
//		if (traineeInDB != null) {
//			manager.remove(traineeInDB);
//		}
//		return Constants.ACCOUNT_DELETED;
//	}

	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
