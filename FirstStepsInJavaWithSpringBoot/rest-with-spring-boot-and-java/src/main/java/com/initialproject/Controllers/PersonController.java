package com.initialproject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.initialproject.data.vo.v1.PersonVO;
import com.initialproject.data.vo.v2.PersonVOV2;
import com.initialproject.exceptions.ResourceNotFoundException;
import com.initialproject.services.PersonService;
import com.initialproject.util.MediaType;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService service;
	// private PersonService service = new PersonService();

	@GetMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/v1/{id}", produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVO findById(@PathVariable(value = "id") String id) {
		String number = id;
		if (!number.matches("[-+]?[0-9]*\\.?[0-9]+")) throw new ResourceNotFoundException("Insert a value Id");
			
		Long Id = Long.valueOf(number);
		return service.findById(Id);

	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML}, produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVO create(@RequestBody PersonVO person) {

		return service.create(person);
	}
	
	@PostMapping(value = "/v2" , consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML}, produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVOV2 createVOV2(@RequestBody PersonVOV2 person) {

		return service.createVo(person);
	}

	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML}, produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		service.Delete(id);
		return ResponseEntity.noContent().build();
	}

}
