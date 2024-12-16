package kr.co.sist.loginpractice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/loginPractice")
public class LoginController {

	@GetMapping("/login")
	public String move() {
		return "loginPractice/loginFrm";
	}

	/*
	 * @PostMapping("/loginFrm") public boolean loginProc(Model model, MemberVO mVO,
	 * HttpServletRequest request) {
	 * 
	 * boolean flag = false;
	 * 
	 * LoginService ls = new LoginService();
	 * 
	 * MemberDomain md = ls.addMember(mVO, request);
	 * 
	 * flag = md != null ? true : false;
	 * 
	 * return flag; }
	 */

	@PostMapping("/loginProc")
	public String loginProc(@ModelAttribute MemberVO mVO, Model model, HttpServletRequest request) {

		mVO.setIp(request.getRemoteAddr());

		LoginService ls = new LoginService();

		ls.setEncryption(mVO);

		ls.getDecryption(mVO);

		// Model로 값 전송
		model.addAttribute("id", mVO.getId());
		model.addAttribute("password", mVO.getPassword());
		model.addAttribute("phone_number", mVO.getPhone_number());
		model.addAttribute("address", mVO.getAddress());
		model.addAttribute("ip", mVO.getIp());

		return "loginPractice/login_process"; // Navigate to your view page
	}

}
