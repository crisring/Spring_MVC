package kr.co.sist.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @Scope("prototype")
@Controller
public class DIController {

	@Autowired
	private ServiceImpl si;

	@GetMapping("/day1209/di")
	public String useSpringContainer(Model model) {

		System.out.println("사용 si객체 : " + si);
		model.addAttribute("addResult", si.add("테스트"));
		model.addAttribute("searchResult", si.search());

		return "day1209/resultDi";
	}
}
