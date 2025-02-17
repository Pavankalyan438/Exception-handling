package com.example.Exception_Training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Exception_Training.dao.Cricketers;

import jakarta.transaction.Transactional;

@Repository
public interface CricketersRepository extends JpaRepository<Cricketers, Integer> {

	Cricketers findByFirstName(String firstName);

	@NativeQuery(value = "select * from Cricketers c where c.salary> ?1")
	List<Cricketers> findBySalary(int salaryValue);
	
	@Query(value = "update Cricketers c set c.salary=?2 where c.id= ?1")
	@Transactional
	@Modifying
	int updateCricketer(int id, int salary);
	

}
