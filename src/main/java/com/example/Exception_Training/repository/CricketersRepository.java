package com.example.Exception_Training.repository;

import com.example.Exception_Training.dao.Cricketers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketersRepository extends JpaRepository<Cricketers, Integer> {

	Cricketers findByFirstName(String firstName);

	@NativeQuery(value = "select * from Cricketers c where c.salary> ?1")
	List<Cricketers> findBySalary(int salaryValue);

}
