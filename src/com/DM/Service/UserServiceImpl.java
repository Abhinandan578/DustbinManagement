package com.DM.Service;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DM.dao.UserDao;

@Repository
public class UserServiceImpl implements UserService {

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
