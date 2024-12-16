package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodController {

	@GetMapping("/request_get")
	public String get() {
		return "day1129/get_result";
	}

	@PostMapping("/request_post")
	public String post() {
		return "day1129/post_result";
	}

	@RequestMapping(value = "/request_get_post", method = { GET, POST })
	// 한개만 사용 가능
	// @GetMapping("/request_get_post")
	// @PostMapping("/request_get_post")
	public String getPost() {
		return "day1129/get_post_result";
	}

} // class
