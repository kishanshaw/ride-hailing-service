package com.xridesbookingdetails.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.xridesbookingdetails.demo.entity.Ride;
import com.xridesbookingdetails.demo.exception.RideNotFoundException;
import com.xridesbookingdetails.demo.repository.RideJPARepository;
import com.xridesbookingdetails.demo.response.Response;
import java.util.*;


@RestController
@RequestMapping("/api")
public class RideRestController {    //this is the main controller that handles HTTP methods calls to the REST end-point.
	
	//Injecting the JPA repository here to perform database operations.
	@Autowired
	private RideJPARepository rideJPARepository;
	
	/*This method handles the GET calls to our REST service,
	 *  and it return all the booked ride details to the API user.
	 */
	@GetMapping("/rides")
	public List<Ride> getAllRideDetails() {
		return rideJPARepository.findAll();
	}
	
	/*This method handles the GET calls to our REST service, 
	 * it returns the ride details for a particular booking_id (id here).
	 * it returns an error response if the record fails to get added with error details
	 */
	@GetMapping("/rides/{id}")
	public Ride getRideById(@PathVariable String id) throws RideNotFoundException{
		Optional<Ride> result = rideJPARepository.findById(id);
		Ride ride = null;
		if(result.isPresent())
			ride=result.get();
		else {
			throw new RideNotFoundException("Ride not found wih id: "+id);
		}
		return ride;
	}
	
	/*This method handles the POST calls to our REST service.
	 * it inserts a record of the passed JSON (as request body) in the database.
	 * and it returns an acknowledgement on a successful operation or a response if the record fails to get added with error details.
	 */
	@PostMapping("/rides")
	public Response addRide(@RequestBody Ride ride, WebRequest request )  throws Exception{
		Ride newRide=rideJPARepository.save(ride);
		if(newRide != null) {
			return new Response(new Date(), "Ride got added", request.getDescription(false));
		}
			
		else
			throw new Exception("Ride details could not be added");
		
	}
	
	
	/*This method handles the PUT calls to our REST service. 
	 * it updates the record of the passed JSON (as request body) in the database using booking_id.
	 * and it returns an acknowledgement on a successful operation or a response if the record fails to get updated with error details.
	 */
	@PutMapping("/rides")
	public Response updateRide(@RequestBody Ride updatedRide, WebRequest request) throws Exception {
		Optional<Ride> existingRide = rideJPARepository.findById(updatedRide.getId()); 
		if(existingRide.isPresent()) {
			Ride newUpdatedRide = rideJPARepository.save(updatedRide);
			if(newUpdatedRide!=null)
				 return new Response(new Date(), "Ride got updated", request.getDescription(false));
			else throw new Exception("Ride details could not be updated");
		}
		else {
			throw new RideNotFoundException("Ride not found wih id: "+updatedRide.getId());
		}
	}
	
	/*This method handles the DELETE calls to our REST service.
	 * it deletes the record from the database using booking_id which is passed.
	 * and it returns an acknowledgement on a successful operation or a response if the record fails to get updated with error details.
	 */
	@DeleteMapping("/rides/{id}")
	public Response deleteRideById(@PathVariable String id, WebRequest request ) throws RideNotFoundException {
		Optional<Ride> existingRide = rideJPARepository.findById(id); 
		if(existingRide.isPresent()) {
				rideJPARepository.deleteById(id);
		}
		 else {
			throw new RideNotFoundException("Ride not found wih booking id: "+id);
		}
		return new Response(new Date(), "Ride details got deleted", request.getDescription(false));
	}
		
}
	
	
		

