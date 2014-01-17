package com.joe.service;

import java.util.List;

import com.joe.bean.Person;

public interface IPersonService {
	public void save(Person person);
	public void update(Person person);
	public void delete(Integer personId);
	public Person getPerson(Integer personId);
	public List<Person> getPersons();
}
