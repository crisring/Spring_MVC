package kr.co.sist.forward;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day1203")
public class ForwardController {

	@GetMapping("/forward")
	public String forwardList() {

		return "day1203/forward_list";
	}// forwardList

	@GetMapping("/forwardA")
	public String forwardA() {
		return "forward:/day1203/forwardA";
	}

	@GetMapping("/forwardB")
	public String forwardB(Model model) {
		model.addAttribute("b_data", "forward에서 생성된 B");
		return "/day1203/forward_result";
	}

	@GetMapping("/forwardC")
	public String forwardC(Model model) {
		model.addAttribute("c_data", "forward에서 생성된 C");
		return "/day1203/forward_result";
	}

}
