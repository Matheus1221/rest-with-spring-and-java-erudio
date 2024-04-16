package br.com.quon.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.quon.data.vo.v2.PersonVOV2;
import br.com.quon.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVo(Person person){
		
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setName(person.getName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		
		return vo;
		
	}
	public Person convertVoToEntity(PersonVOV2 person){
		
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		//vo.setBirthDay(new Date());
		entity.setName(person.getName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		return entity;
		
	}

}
