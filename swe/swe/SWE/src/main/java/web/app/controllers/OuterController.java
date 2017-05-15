package web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OuterController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String ShowWelcomePage()
	{
		return "welcom";
		 
	}
	@RequestMapping(value="/signin/options",method=RequestMethod.GET)
	public String ShowSignInOptions()
	{
		return"signinoptions";
	}
	@RequestMapping(value="/signup/options",method=RequestMethod.GET)
	public String ShowSignUpOptions()
	{
		return"signupoptions";
	}
	

		
	

}
