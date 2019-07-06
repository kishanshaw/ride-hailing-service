package com.xridesbookingdetails.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.xridesbookingdetails.demo.entity.Ride;


/*This is the interface that uses the Java Persistence API to perform the JDBC operations*/
@Repository
public interface RideJPARepository extends MongoRepository<Ride, String> {

}
