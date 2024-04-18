package br.com.quon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.quon.util.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.quon.data.vo.v1.PersonVO;

import br.com.quon.services.PersonServices;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service ;

	

	@GetMapping(
			produces = {MediaType.APPLICATION_JSON,
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public List<PersonVO> findAll() {

		return service.findAll();
	}
	
	
	@GetMapping(value = "/{id}",
			produces= {MediaType.APPLICATION_JSON,
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public PersonVO findById(@PathVariable (value = "id") Long id) throws Exception {

		return service.findById(id);
	}
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML},
			produces= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}
	
	@PutMapping(
			consumes= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML},
			produces= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();	}

	
	
}
