package com.initialproject.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initialproject.data.vo.v1.PersonVO;
import com.initialproject.data.vo.v2.PersonVOV2;
import com.initialproject.exceptions.ResourceNotFoundException;
import com.initialproject.mapper.DozerMapper;
import com.initialproject.mapper.custom.PersonMapper;
import com.initialproject.model.Person;
import com.initialproject.repositories.PersonRepository;



@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonMapper personMapper;
	
	

	
	
	public List<PersonVO> findAll(){
	
		logger.info("finding all person!");

		return DozerMapper.parseListObject(repository.findAll(),PersonVO.class);
		
	}
	
	public PersonVO findById(Long id) {
				
		logger.info("finding one person!");
		
		var entity =   repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("No records found for this ID"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
		
		

	}
	
	public PersonVO create(PersonVO person) {
		
		logger.info("creating one person!");
		person.setId(null);
		return DozerMapper.parseObject(repository.save(DozerMapper.parseObject(person , Person.class)),PersonVO.class);
		
	}
	
   public PersonVOV2 createVo(PersonVOV2 person) {
		
		logger.info("creating one person V2!");
		person.setId(null);
        return personMapper.convertEntityToVo(repository.save(personMapper.convertVoToEntity(person)));
		
	}
	
	public PersonVO update(PersonVO person) {
		
		logger.info("updating one person!");
		
		Person entity = repository.getReferenceById(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
    
		return DozerMapper.parseObject(repository.save(entity),PersonVO.class);

	}
	
	public void Delete (Long id) {
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
}


