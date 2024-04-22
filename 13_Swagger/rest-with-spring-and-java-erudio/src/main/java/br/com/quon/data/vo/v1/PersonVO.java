package br.com.quon.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;





@JsonPropertyOrder({"id","name","lastName","address","gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	@JsonProperty("id")
	@Mapping("id")
	private long key;
	
	
	private String name;
	
	private String lastName;
	
	
	private String address;
	

	private String gender;
	
	
	public PersonVO() {}
	
	public long getKey() {
		return key;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setKey(long key) {
		this.key = key;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(address, gender, key, lastName, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(address, other.address) && Objects.equals(gender, other.gender) && key == other.key
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}


	
	
	
}
