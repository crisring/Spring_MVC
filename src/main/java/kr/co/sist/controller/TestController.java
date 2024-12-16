package kr.co.sist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class TestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		System.out.println("abcdefg");
		return "hello"; // prefix : ?, suffix : ? 와 연결되어 JSP를 찾는다.
	}

}
