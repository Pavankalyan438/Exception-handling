package com.example.Exception_Training.service;

import com.example.Exception_Training.dao.Cricketers;
import com.example.Exception_Training.exception.CricketerAlreadyExist;
import com.example.Exception_Training.exception.NoSuchCricketerException;
import com.example.Exception_Training.repository.CricketersRepository;
import com.example.Exception_Training.repository.JdbcCricketerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CricketersServiceImp {
	

	@Autowired
	public CricketersRepository cricketersRepository;

	@Autowired
	public JdbcCricketerRepository jdbcCricketerRepository;

	public Cricketers findById(int id) {

		return cricketersRepository.findById(id)
				.orElseThrow(() -> new NoSuchCricketerException("No cricketer found with Id: " + id));

	}

	public Cricketers saveCricketer(Cricketers cricketers) {
		Cricketers alreadyExist = cricketersRepository.findById(cricketers.getId()).orElse(null);
		if (alreadyExist == null)
			return cricketersRepository.save(cricketers);
		throw new CricketerAlreadyExist("cricketer already exist with: " + cricketers.toString());

	}

	public List<Cricketers> findBySalaryValue(int salaryValue, String firstname) {
		// TODO Auto-generated method stub
		//return cricketersRepository.findBySalary(salaryValue);
		//cricketersRepository.findall
		return jdbcCricketerRepository.findCricketersWithSalaryAbove(salaryValue, firstname);
	}

	public List<Cricketers> findByPage(int pageId, int pageSize) {
		// TODO Auto-generated method stub
		Page<Cricketers> allCricketrs = cricketersRepository
				.findAll(PageRequest.of(pageId, pageSize, Sort.by("salary")));

		System.out.println(allCricketrs);
		return allCricketrs.toList();
	}

	public String updateCricketer(Cricketers cricketers) {
		
		cricketersRepository.updateCricketer(cricketers.getId(), cricketers.getSalary());
		return "Updated Succesfully";
	}

	
}
