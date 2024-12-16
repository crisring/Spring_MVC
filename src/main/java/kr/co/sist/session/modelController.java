package kr.co.sist.session;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;

//@SessionAttributes("model_name")
@SessionAttributes({ "model_name", "model_data" })
@Controller
@RequestMapping("/day1204")
public class modelController {

	@GetMapping("/model")
	public String add(Model model) {

		model.addAttribute("model_name", "안정현");
		String[] data = { "순대국", "자장면", "돈가츠", "칼국수" };
		model.addAttribute("model_data", data);

		return "day1204/model_add";
	}// add

	@GetMapping("/read_model")
	public String read(HttpSession session) {

		session.setMaxInactiveInterval(10);

		// Controller의 method에서 설정된 sessin 값 얻기
		String name = (String) session.getAttribute("model_name");
		String[] data = (String[]) session.getAttribute("model_data");
		System.out.println("/day1204/model_add");
		System.out.println(name);
		System.out.println(Arrays.toString(data));

		return "/day1204/model_add";
	}

	@GetMapping("/remove_model")
	public String remove(SessionStatus ss) {

		// 4. 세션 값 삭제
		ss.setComplete();

		// Query String이 붙어 나올 수도 있다. -> 해결 : redirect를 직접 사용하지 않는다. , JSP로 이동한 후 location.href로 이동한다.
		return "redirect:/";
	}

}// class
