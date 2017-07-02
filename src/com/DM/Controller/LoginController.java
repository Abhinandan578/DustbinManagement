package com.DM.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.DM.delegate.LoginDelegate;
import com.DM.entity.Users;

@Controller
@RequestMapping("/user")
public class LoginController
{
	
			@Autowired
			private LoginDelegate loginDelegate;
			
			Users user = new Users();
			
//			@RequestMapping(value="/login",method=RequestMethod.GET)
			@GetMapping(value="/login")
			public ModelAndView displayLogin(HttpServletRequest request,HttpServletResponse response)
			{
					ModelAndView model = new ModelAndView("login");
					
					model.addObject("Users",user);
					return model;
			}
			
			@PostMapping(value="/login")
			public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response)
			{
						ModelAndView model=null;
						try
						{
								boolean isValidUser = loginDelegate.isValidUser(user.getId(),user.getPassword());
								if(isValidUser)
								{
										System.out.println("User Login Succesful");
										request.setAttribute("loggedInUser", user.getId());
										model = new ModelAndView("Welcome");
								}
								else
								{
										model = new ModelAndView("login");
										model.addObject("Users", user);
										request.setAttribute("message", "Invalid credentials!!");
								}
						}
						catch(Exception e)
						{
								e.printStackTrace();
						}
						return model;
			}
}

