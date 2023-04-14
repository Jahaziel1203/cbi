package com.cbi.cbi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.cbi.cbi.models.entity.Authentication;

public interface IAuthenticationDao extends CrudRepository<Authentication, Integer> {

}