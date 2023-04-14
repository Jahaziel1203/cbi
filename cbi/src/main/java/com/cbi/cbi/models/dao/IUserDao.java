package com.cbi.cbi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.cbi.cbi.models.entity.User;

public interface IUserDao extends CrudRepository<User, Integer>{

}