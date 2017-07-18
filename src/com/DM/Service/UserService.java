package com.DM.Service;

import java.sql.SQLException;
import java.util.List;

import com.DM.entity.Dustbin;
import com.DM.entity.Users;

public interface UserService {
	
		public boolean isValidUser(int id,String password) throws SQLException;

		public List<Users> getCollectors();

		public List<Users> getCaretakers();
		
		public void saveUser(Users theuser);
		
		public void saveDustbin(Dustbin theDustbin);

		public Users getUser(int theId);

		public void deleteUser(int theId);
		
		public List<Dustbin> getDustbin(int theId);
		
		public List<Dustbin> getDustbins();
}
