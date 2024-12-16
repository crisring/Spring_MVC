package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 1. 클래스 위에 @Controller 선언
@Controller
public class MainController {

	// 2. 요청을 처리할 수 있는 method를 정의하고
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
