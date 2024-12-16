package kr.co.sist.session;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/day1204")
public class SessionController {

	@GetMapping("/session")
	public String add(HttpSession session, HttpServletRequest request) {
		// 값 설정
		System.out.println(session);

		/*
		 * HttpSession test = request.getSession(); System.out.println(test);
		 */
		session.setAttribute("name", "김현우");
		String[] data = { "자바", "JSP", "Spring Boot", "HTML" };
		session.setAttribute("data", data);

		return "day1204/session_add";
	}

	@GetMapping("/read_session")
	public String read(HttpSession session) {

		session.setMaxInactiveInterval(10);

		// Controller의 method에서 설정된 sessin 값 얻기
		String name = (String) session.getAttribute("name");
		String[] data = (String[]) session.getAttribute("data");
		System.out.println("/day1204/session_add");
		System.out.println(name);
		System.out.println(Arrays.toString(data));

		return "/day1204/session_add";
	}

	@GetMapping("/remove_session")
	public String remove(HttpSession session) {

		// 4. 세션 값 삭제
		session.removeAttribute("data");

		// 5. 세션 무효화(로그아웃)
		session.invalidate();

		return "day1204/session_add";
	}
}
