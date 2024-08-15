package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/")
	@ResponseBody
	public String Testhandler()
	{
		return "Welcome to first sts git check Demo World";
	}
	
	@RequestMapping("/home")
	public String homepage()
	{
		return "home" ; 
	}
	
	@RequestMapping("/contact")
	public String contactpage()
	{
		return "contact" ; 
	}
	
}
