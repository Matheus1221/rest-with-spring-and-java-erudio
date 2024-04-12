package br.com.quon.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	
	private long id;
	private String name;
	private String lastName;
	private String address;
	private String gender;
	public Person() {}
	
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(address, gender, id, lastName, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}
	
	
	
	
	
}
