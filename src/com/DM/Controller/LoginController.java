package com.DM.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DM.Service.UserService;
import com.DM.entity.Users;

@Controller
@RequestMapping("/user")
public class LoginController
{
	
			@Autowired
			private UserService userService;
			
			
			
			@GetMapping("/login")
//			@ModelAttribute("user")
			public String displayLogin(@ModelAttribute("user") Users theUser,HttpServletRequest request,HttpServletResponse response,Model theModel)
			{
					Users theNewUser = new Users();
					theModel.addAttribute("myuser",theNewUser);
					theModel.addAttribute("user",new Users());
					return "delete";
			}
			
			@PostMapping("/login")
			public String executeLogin(HttpServletRequest request,HttpServletResponse response,Model theModel)
			{
						String retString=new String();
						try
						{
								Users theUser = new Users();
								
								boolean isValidUser = userService.isValidUser(theUser.getId(),theUser.getPassword());
								if(isValidUser)
								{
										System.out.println("User Login Succesful");
										request.setAttribute("loggedInUser", theUser.getId());
										retString= "Welcome";
								}
								else
								{

										theModel.addAttribute("user", theUser);
										request.setAttribute("message", "Invalid credentials!!");
										retString="login";
								}
						}
						catch(Exception e)
						{
								e.printStackTrace();
						}
						return retString;
			}
}

