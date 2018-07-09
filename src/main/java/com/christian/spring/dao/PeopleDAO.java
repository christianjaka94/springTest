package com.christian.spring.dao;

import java.util.List;

import com.christian.spring.entity.People;

public interface PeopleDAO {

	public void addPeople(People p);
	public void updatePeople(People p);
	public List<People> listPeople();
	public People getPeopleById(long id);
	public void removePeople(long id);
}
