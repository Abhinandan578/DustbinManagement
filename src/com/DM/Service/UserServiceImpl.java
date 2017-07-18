package com.DM.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DM.dao.UserDao;
import com.DM.entity.Dustbin;
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
<<<<<<< HEAD
=======
			
		}
		@Override
		@Transactional
		public List<Dustbin> getDustbin(int theId) {
			List<Dustbin> theUsers = userDao.getDustbin(theId);
			return theUsers;
		}
		@Override
		@Transactional
		public List<Dustbin> getDustbins() {
			List<Dustbin> theUsers = userDao.getDustbins();
			return theUsers;
		}
		@Override
		@Transactional
		public void saveDustbin(Dustbin theDustbin) {
			userDao.saveDustbin(theDustbin);
>>>>>>> branch 'vartika' of https://github.com/Abhinandan578/DustbinManagement.git
			
		}

}
