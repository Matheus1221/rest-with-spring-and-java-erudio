package br.com.quon.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quon.exception.ResourceNotFoundException;
import br.com.quon.model.Person;
import br.com.quon.repositories.PersonRepository;


@Service
public class PersonServices {

	

	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());


	@Autowired
	PersonRepository repository;
	
	public Person findById;

	
	public List<Person> findAll() {
		logger.info("Finding all people!");

		return repository.findAll();  
		
	}

	public Person findById(Long id) {  
		
		
		logger.info("Finding one person!");
	
		

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
	}
	
	
	public Person create(Person person) {
		logger.info("crating one person!");
		return repository.save(person);
	}
	
	
	public Person update(Person person) {
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
