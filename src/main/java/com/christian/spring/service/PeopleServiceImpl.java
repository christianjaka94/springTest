package com.christian.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.spring.dao.PeopleDAO;
import com.christian.spring.entity.People;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleDAO peopleDAO;

	public void setPeopleDAO(PeopleDAO peopleDAO) {
		this.peopleDAO = peopleDAO;
	}

	@Override
	@Transactional
	public void addPeople(People p) {
		this.peopleDAO.addPeople(p);
	}

	@Override
	@Transactional
	public void updatePeople(People p) {
		this.peopleDAO.updatePeople(p);
	}

	@Override
	@Transactional
	public List<People> listPeople() {
		return this.peopleDAO.listPeople();
	}

	@Override
	@Transactional
	public People getPeopleById(long id) {
		return this.peopleDAO.getPeopleById(id);
	}

	@Override
	@Transactional
	public void removePeople(long id) {
		this.peopleDAO.removePeople(id);
	}

}
