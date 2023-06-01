package br.com.A3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/")
	public String index () {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about () {
		return "about";
	}
	
	@RequestMapping("cadastroLogin")
	public String cadastroLogin () {
		return "cadastroLogin";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	///

}
