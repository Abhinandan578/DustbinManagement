package com.DM.Service;

import java.sql.SQLException;

public interface UserService {
	
		public boolean isValidUser(String id,String password) throws SQLException;

}
