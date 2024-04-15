package br.com.quon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import br.com.quon.model.Person;
import br.com.quon.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service ;
//	private PersonServices service = new PersonServices();
	
	

	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {

		return service.findAll();
	}
	
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable (value = "id") String id) throws Exception {

		return service.findById(id);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (value = "id") String id) {

		service.delete(id);
	}
	
}
