package com.cbi.cbi.models.service;

import java.util.List;

import com.cbi.cbi.models.entity.Rol;

public interface IRolService {

	public List<Rol> findAll();

	public Rol findById(Integer id);

}