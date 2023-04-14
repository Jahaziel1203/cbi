package com.cbi.cbi.models.service;

import java.util.List;

import com.cbi.cbi.models.entity.User;

public interface IUserService {

	public List<User> findAll();

	public void save(User user);

	public User findById(Integer id);

	public void delete(Integer id);

}