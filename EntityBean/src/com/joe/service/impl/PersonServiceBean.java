package com.joe.service.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.joe.bean.Person;
import com.joe.service.IPersonService;

@Stateless
@Remote(IPersonService.class)
public class PersonServiceBean implements IPersonService {
	@PersistenceContext(unitName="joePersistenceUnit") EntityManager em;
	
	@Override
	public void save(Person person) {
		em.persist(person);
	}

	@Override
	public void update(Person person) {
		//pre-condition: person is a YOULI status
		em.merge(person);
	}

	@Override
	public void delete(Integer personId) {
		em.remove(em.getReference(Person.class, personId));
	}

	@Override
	public Person getPerson(Integer personId) {
		return em.find(Person.class, personId);
	}

	@Override
	public List<Person> getPersons() {
		//JPQL: Person is case-sensitive
		return em.createQuery("select o from Person o").getResultList();
	}
}