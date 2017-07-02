package com.DM.delegate;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DM.Service.UserService;

@Component
public class LoginDelegate {

			@Autowired
			private UserService userService;
			
			
			public UserService getUserService() {
				return userService;
			}
			public void setUserService(UserService userService)
			{
						this.userService = userService;
			}
			public boolean isValidUser(String id,String password) throws SQLException
			{
						return userService.isValidUser(id,password);
			}
}
