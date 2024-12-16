package kr.co.sist.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

	@RequestMapping(value = "/header", method = { RequestMethod.GET, RequestMethod.POST })
	public String header(Model model) {
		model.addAttribute("name", "테스트");
		return "common/header";
	}
}
