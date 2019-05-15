package com.xridesbookingdetails.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xridesbookingdetails.demo.entity.Ride;


/*This is the interface that uses the Java Persistence API to perform the JDBC operations*/
public interface RideJPARepository extends JpaRepository<Ride, Integer> {

}
