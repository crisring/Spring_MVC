package kr.co.sist.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestAPIController {

	@GetMapping("/day1220/restful")
	public String htmlResponse() {

		return "day1220/restful";
	}// htmlResponse

}// class
