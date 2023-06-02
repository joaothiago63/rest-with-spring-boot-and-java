package com.initialproject.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initialproject.exceptions.ResourceNotFoundException;
import com.initialproject.model.Person;
import com.initialproject.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll(){
	
		logger.info("finding all person!");

		return repository.findAll();
		
	}
	
	public Person findById(Long id) {
				
		logger.info("finding one person!");
		
		
		return  repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("No records found for this ID"));
		
		

	}
	
	public Person create(Person person) {
		
		logger.info("creating one person!");
		person.setId(null);
		return repository.save(person);
		
	}
	
	public Person update(Person person) {
		
		logger.info("updating one person!");
		
		Person entity = repository.getReferenceById(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
    
		return repository.save(entity);

	}
	
	public void Delete (Long id) {
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
}


