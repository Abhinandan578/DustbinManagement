package com.DM.dao;

import java.sql.SQLException;

public interface UserDao {

		public boolean isValidUser(String id,String password) throws SQLException;
}
