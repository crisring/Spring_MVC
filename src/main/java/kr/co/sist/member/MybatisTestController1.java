package kr.co.sist.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MybatisTestController1 {

	@Autowired(required = false)
	private MybatisService1 mbs;

	@GetMapping("/member/memberList")
	public String mybatisTest(Model model) {

		List<Integer> list = mbs.searchAllEmpno();
		model.addAttribute("data", list);

		return "member/searchEmpno";
	}

	@PostMapping("/member/empDetail")
	public String ajaxProcess(int empno, Model model) {

		String jsonObj = mbs.searchOneEmp(empno);
		System.out.println(jsonObj);
		model.addAttribute("jsonObj", mbs.searchOneEmp(empno));

		return "member/createJson";
	}

}
