package com.DM.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DM.dao.UserDao;
import com.DM.entity.Users;

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
		public boolean isValidUser(int id, String password) throws SQLException {
			
					return userDao.isValidUser(id,password) ;
		}
		@Override
		@Transactional
		public List<Users> getCollectors() {
			
			return userDao.getCollectors();
			
		}
		@Override
		@Transactional
		public List<Users> getCaretakers() {
			
			return userDao.getCaretakers();
			
		}
		@Override
		@Transactional
		public void saveUser(Users theuser) {
			userDao.saveUser(theuser);
			
		}
		@Override
		@Transactional
		public Users getUser(int theId) {
			return userDao.getUser(theId);
		}
		@Override
		@Transactional
		public void deleteUser(int theId) {
			userDao.deleteUser(theId);
			
		}

}
