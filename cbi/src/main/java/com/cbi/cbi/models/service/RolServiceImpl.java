package com.cbi.cbi.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbi.cbi.models.dao.IRolDao;
import com.cbi.cbi.models.entity.Rol;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }
}