package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@GetMapping("/demo")
	@ResponseBody
	public String demoMsg(@RequestParam ("name")String name)
	{
		return name + " ,Hello World";
	}
	
}
