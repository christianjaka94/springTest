package com.christian.spring.service;

import java.util.List;

import com.christian.spring.entity.People;

public interface PeopleService {

	public void addPeople(People p);
	public void updatePeople(People p);
	public List<People> listPeople();
	public People getPeopleById(long id);
	public void removePeople(long id);
	
}
