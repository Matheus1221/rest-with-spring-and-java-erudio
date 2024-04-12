package br.com.quon.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.quon.model.Person;


@Service
public class PersonServices {

	

	
	
	private final AtomicLong counter = new AtomicLong();
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());


	public Person findById;

	
	public Person findById(String id) {
		
		
		logger.info("Finding one person!");
		Person person = new Person(); 
		
		person.setId(counter.incrementAndGet());
		person.setName("Matheus");
		person.setLastName("Quon");
		person.setAddress("São Paulo");
		person.setGender("Male");
		return person;
	}


}
