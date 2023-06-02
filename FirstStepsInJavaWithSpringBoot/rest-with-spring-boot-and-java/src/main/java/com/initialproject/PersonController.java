package com.initialproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.initialproject.exceptions.ResourceNotFoundException;
import com.initialproject.model.Person;
import com.initialproject.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	//private PersonService service = new PersonService();

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Person>findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) {
		String number = id;
		if(!number.matches("[-+]?[0-9]*\\.?[0-9]+")) throw new ResourceNotFoundException("Insert a value Id");
  		Long Id = Long.valueOf(number);
  		return service.findById(Id);
		
	}
		
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
    	
    	return service.create(person);
    }
    
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
    	return service.update(person);
    }
    
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
    	service.Delete(id);
    	return ResponseEntity.noContent().build();
    }

	
	
	
}
