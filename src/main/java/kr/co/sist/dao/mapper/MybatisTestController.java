package kr.co.sist.dao.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MybatisTestController {

	@Autowired(required = false)
	private MybatisService mbs;

	@GetMapping("/day1210/searchEmpno")
	public String mybatisTest(Model model) {

		List<Integer> list = mbs.searchAllEmpno();
		model.addAttribute("data", list);

		return "day1210/searchEmpno";
	}

	@PostMapping("/day1210/empDetail")
	public String ajaxProcess(int empno, Model model) {

		String jsonObj = mbs.searchOneEmp(empno);
		System.out.println(jsonObj);
		model.addAttribute("jsonObj", mbs.searchOneEmp(empno));

		return "day1210/createJson";
	}

}
