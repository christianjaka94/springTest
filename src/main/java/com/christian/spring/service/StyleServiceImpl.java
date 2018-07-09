package com.christian.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.spring.dao.StyleDAO;
import com.christian.spring.entity.Style;

@Service("styleService")
public class StyleServiceImpl implements StyleService {
	
	@Autowired
	private StyleDAO styleDAO;

	public void setStyleDAO(StyleDAO styleDAO) {
		this.styleDAO = styleDAO;
	}

	@Override
	@Transactional
	public void addStyle(Style s) {
		this.styleDAO.addStyle(s);
	}

	@Override
	@Transactional
	public void updateStyle(Style s) {
		this.styleDAO.updateStyle(s);
	}

	@Override
	@Transactional
	public List<Style> listStyles() {
		return this.styleDAO.listStyles();
	}

	@Override
	@Transactional
	public Style getStyleById(long id) {
		return this.styleDAO.getStyleById(id);
	}

	@Override
	@Transactional
	public void removeStyle(long id) {
		this.styleDAO.removeStyle(id);
	}

}
