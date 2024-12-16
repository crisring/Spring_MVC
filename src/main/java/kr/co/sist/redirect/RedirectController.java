package kr.co.sist.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day1203")
public class RedirectController {

	@GetMapping("/redirect")
	public String redirectList() {

		return "/day1203/redirect_list";
	}// redirectList

	@GetMapping("/call_html")
	public String moveHtml() {

		return "redirect:/test.html";
	}// moveHtml

	@GetMapping("/call_controller")
	public String moveController() {

		return "redirect:/day1202/send_data";
	}// moveController

}
