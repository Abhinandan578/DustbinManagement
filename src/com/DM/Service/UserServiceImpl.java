package com.DM.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DM.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

		@Autowired
		private UserDao userDao;
		
		public UserDao getUserDao()
		{
				return this.userDao;
		}
		public void setUserDao(UserDao userDao)
		{
				this.userDao = userDao;
		}
		@Override
		@Transactional
		public boolean isValidUser(String id, String password) throws SQLException {
			
					return userDao.isValidUser(id,password) ;
		}

}
