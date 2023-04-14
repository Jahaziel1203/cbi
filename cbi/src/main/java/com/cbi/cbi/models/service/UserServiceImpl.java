package com.cbi.cbi.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbi.cbi.models.dao.IAuthenticationDao;
import com.cbi.cbi.models.dao.IUserDao;
import com.cbi.cbi.models.entity.Authentication;
import com.cbi.cbi.models.entity.User;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

	@Autowired
	private IAuthenticationDao authenticationDao;

    @Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		Authentication authentication = user.getAuthentication();
		authentication.setUser(userDao.save(user));
		authenticationDao.save(authentication);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Integer id) {
		return userDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userDao.deleteById(id);
	}
}