package kr.co.sist.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

/**
 * HTML Form Control의 값을 Controller의 method에 처리
 */
@Controller
public class ParamController {

	@GetMapping("/param/param_test")
	public String paramList() {

		return "day1202/param_list";
	}

	/* @GetMapping("/param/single_param") */
	@PostMapping("/param/single_param")
	public String singleParam(String name) {

		System.out.println("입력값 :" + name);
		return "day1202/single_param_result";
	}

	@GetMapping("/param/multi_param_request")
	public String useRequest(HttpServletRequest request) {

		// 이름 나이 주소
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] addr = request.getParameterValues("addr");
		String ip = request.getRemoteAddr();
		String userAgent = request.getHeader("User-Agent");

		System.out.println(name + " " + age);

		if (addr != null) {

			for (String temp : addr) {
				System.out.println(temp);

			}

		} else {
			System.out.println("주소값이 없습니다.");
		}
		System.out.println(ip + " " + userAgent);
		return "day1202/multi_param_result";
	}

	@GetMapping("/param/multi_param_vo")
	public String useVO(ParamVO pVO, HttpServletRequest request) {

		pVO.setIp(request.getRemoteAddr());
		pVO.setUserAgent(request.getHeader("User-Agent"));

		System.out.println(pVO.toString());
		return "day1202/multi_param_result";
	}

}
