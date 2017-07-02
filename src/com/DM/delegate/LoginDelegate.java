package com.DM.delegate;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.DM.Service.UserService;

@Component
public class LoginDelegate {

			private UserService userService;
			
			public UserService getUserService(UserService userService)
			{
						this.userService = userService;
						return userService;
			}
			public boolean isValidUser(String id,String password) throws SQLException
			{
						return userService.isValidUser(id,password);
			}
}
