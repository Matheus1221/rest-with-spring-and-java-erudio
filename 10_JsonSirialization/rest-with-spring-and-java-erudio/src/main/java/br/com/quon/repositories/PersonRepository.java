package br.com.quon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quon.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{}
