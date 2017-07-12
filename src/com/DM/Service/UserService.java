package com.DM.Service;

import java.sql.SQLException;
import java.util.List;

import com.DM.entity.Users;

public interface UserService {
	
		public boolean isValidUser(int id,String password) throws SQLException;

		public List<Users> getCollectors();

		public List<Users> getCaretakers();
		
		public void saveUser(Users theuser);

		public Users getUser(int theId);

		public void deleteUser(int theId);
}
