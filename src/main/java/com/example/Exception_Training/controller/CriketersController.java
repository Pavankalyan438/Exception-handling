package com.example.Exception_Training.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception_Training.dao.Cricketers;
import com.example.Exception_Training.repository.CricketersRepository;
import com.example.Exception_Training.service.CricketersServiceImp;

@RestController
@Configuration
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/ipl")
public class CriketersController {

	@Autowired
	public CricketersServiceImp cricketersServiceImp;
	@Autowired
	public CricketersRepository cricketersRepository;

	@GetMapping(path = "/firstname")
	public ResponseEntity<Cricketers> findById(@RequestParam int id) {
		Cricketers cricketers = cricketersServiceImp.findById(id);
		/*
		 * try {
		 * 
		 * cricketers = cricketersServiceImp.findById(id); }catch (Exception e) {
		 * //return ResponseEntity.status(HttpStatus.OK).body(cricketers);
		 * System.out.println("errrr:"+ e.getMessage()); }
		 */
		return ResponseEntity.status(HttpStatus.OK).body(cricketers);

	}

	@GetMapping(path = "/hello")
	public ResponseEntity<List<Cricketers>> helloWorld() {

		return ResponseEntity.status(HttpStatus.OK).body(cricketersRepository.findAll());

	}

	@PostMapping(path = "/post")
	public Cricketers helloWorld(@RequestBody Cricketers cricketers) {
System.out.println(cricketers.toString());
		return cricketersServiceImp.saveCricketer(cricketers);

	}

	/*
	 * @ExceptionHandler(value = NoSuchCricketerException.class)
	 * 
	 * @ResponseStatus(HttpStatus.CONFLICT) public ErrorResponse
	 * handleCustomerAlreadyExistsException(NoSuchCricketerException ex) { return
	 * new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage()); }
	 */

	@GetMapping(value = "/findBySalary/{salary}/{firstname}")
	public ResponseEntity<List<Cricketers>> findBySalaryValue(@PathVariable("salary") int salaryValue,
			@PathVariable("firstname") String fname) {

		return new ResponseEntity<List<Cricketers>>(cricketersServiceImp.findBySalaryValue(salaryValue, fname),
				HttpStatus.OK);
	}

	@GetMapping(value = "findByPageAndSorting/{pageid}/{pageSize}")
	public ResponseEntity<List<Cricketers>> findByPage(@PathVariable("pageid") int pageId,
			@PathVariable("pageSize") int pageSize) {

		return new ResponseEntity<List<Cricketers>>(cricketersServiceImp.findByPage(pageId, pageSize), HttpStatus.OK);
	}
	@Bean
	public Function<Cricketers, Cricketers> knowCricketer()
	{
		return cricketer->cricketer;
	}
}
