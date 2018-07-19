package com.qa.interoperability;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.service.business.TraineeService;

@Path("trainee")
public class TraineeEndpoint {
	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);
	
	@Inject
	private TraineeService traineeService;
	
	@GET
	@Path("/json")
	@Produces( {"application/json"})
	public String getAllTrainees() {
		return traineeService.getAllTrainees();		
	}
	
//	@POST
//	@Path("/json")
//	@Produces({"application/json"})
//	public String addTrainee(String trainee) {
//		return traineeService.addTrainee(trainee);
//	}
//	
//	@PUT
//	@Path("/json/{id}")
//	@Produces({"application/json"})
//	public String updateTrainee(@PathParam("id") Long id, String trainee) {
//		LOGGER.info("In traineeEndpoint updatetrainee");
//		return traineeService.updateTrainee(id, trainee);
//	}
//	
//	@DELETE
//	@Path("/json/{id}")
//	@Produces({"application/json"})
//	public String deleteTrainee(@PathParam("id") Long id) {
//		return traineeService.deleteTrainee(id);
//	}
	
	public void setTraineeService(TraineeService traineeService) {
		this.traineeService = traineeService;
	}

}
