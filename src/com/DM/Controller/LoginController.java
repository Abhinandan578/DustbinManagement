package com.DM.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DM.Service.UserService;
import com.DM.entity.Users;

@Controller
@RequestMapping("/user")
public class LoginController
{
	
			@Autowired
			private UserService userService;
			
			@GetMapping("/login")
			public String displayLogin(HttpServletRequest request,HttpServletResponse response,Model theModel)
			{
					Users theNewUser = new Users();
					theModel.addAttribute("user", theNewUser);
					return "delete";
			}
			
			@PostMapping("/login")
			public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") Users theUser)
			{
						String retString=new String();
						ModelAndView theModel=null;
						
						try
						{
								request.setAttribute("loggedInUser", theUser.getId());
								System.out.println(theUser.getId() + theUser.getPasswordUser());
								boolean isValidUser = userService.isValidUser(theUser.getId(),theUser.getPasswordUser());
								if(isValidUser)
								{
										System.out.println("User Login Succesful");
										request.setAttribute("loggedInUser", theUser.getId());
										theModel=new ModelAndView("welcome");
								}
								else
								{

										theModel.addObject("user", theUser);
										request.setAttribute("message", "Invalid credentials!!");
										theModel=new ModelAndView("listCollector");
								}
						}
						catch(Exception e)
						{
								e.printStackTrace();
						}
						return theModel;

			}
			
			
			@RequestMapping("/listCollector")
			//@ModelAttribute("user")
			public String listCollectors(Model theModel)
			{
				List<Users> theUser= userService.getCollectors();
				
				theModel.addAttribute("user",theUser);
				//theModel.addAttribute("user",new Users());
				return "listCollector";
			}
			
			@RequestMapping("/listCareTaker")
			public String listCaretakers(Model theModel)
			{
				List<Users> theuser= userService.getCaretakers();
				
				theModel.addAttribute("user",theuser);
				return "listCaretaker";
			}
			
			@GetMapping("/showFormForAdd")
			public String showFormForAdd(Model theModel)
			{
				Users theUser = new Users();
				
				theModel.addAttribute("user" , theUser);
				
				return "user-form";
			}
			
			@PostMapping("/saveUser")
			public String saveUser(@ModelAttribute("user") Users theUser)
			{System.out.println(theUser);
				userService.saveUser(theUser);
				
				return "redirect:/user/listCollector";
			}
			
			@GetMapping("/showFormForUpdate")
			public String showFormForUpdate(@RequestParam("userId") int theId,Model theModel)
			{
				Users theuser = userService.getUser(theId);
				
				theModel.addAttribute("user" , theuser);
				
				return "redirect:/user/list";
			}
			
			
			@GetMapping("/delete")
			public String delete(@RequestParam("userId") int theId,Model theModel)
			{
				userService.deleteUser(theId);
				
				return "redirect:/user/list";
			}
			
}

