package br.com.quon.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.quon.controllers.PersonController;
import br.com.quon.data.vo.v1.PersonVO;
import br.com.quon.exception.ResourceNotFoundException;
import br.com.quon.mapper.DozerMapper;

import br.com.quon.model.Person;
import br.com.quon.repositories.PersonRepository;


@Service
public class PersonServices {

	

	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());


	@Autowired
	PersonRepository repository;
	
	@Autowired

	

	
	public List<PersonVO> findAll() {
		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;  
		
	}

	public PersonVO findById(Long id) {  
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		PersonVO  vo =  DozerMapper.parseObject(entity, PersonVO.class);
		try {
			vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	
	
	
	public PersonVO create(PersonVO person) {
		logger.info("crating one person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("updating one person!");
		var entity = repository.findById(person.getKey())
		.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		entity.setName(person.getName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
	
		return vo;
	}
	
	public void  delete(Long id) {
		logger.info("deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Records found for this ID!"));
		
		repository.delete(entity);
	}

}


