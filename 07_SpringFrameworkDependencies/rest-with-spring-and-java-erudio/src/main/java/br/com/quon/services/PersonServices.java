package br.com.quon.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quon.exception.ResourceNotFoundException;
import br.com.quon.data.vo.v1.PersonVO;
import br.com.quon.repositories.PersonRepository;


@Service
public class PersonServices {

	

	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());


	@Autowired
	PersonRepository repository;
	

	
	public List<PersonVO> findAll() {
		logger.info("Finding all people!");

		return repository.findAll();  
		
	}

	public PersonVO findById(Long id) {  
		
		
		logger.info("Finding one person!");
	
		

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
	}
	
	
	public PersonVO create(PersonVO person) {
		logger.info("crating one person!");
		return repository.save(person);
	}
	
	
	public PersonVO update(PersonVO person) {
		logger.info("updating one person!");
		
		var entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		
		;
		entity.setName(person.getName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(person);
	}
	
	public void  delete(Long id) {
		logger.info("deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		
		repository.delete(entity);
	}

}


