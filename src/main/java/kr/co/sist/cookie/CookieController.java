package kr.co.sist.cookie;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/day1205")
public class CookieController {

	@GetMapping("/cookie")
	public void workList() {

	}

	@GetMapping("/addCookie")
	public String addCookie(HttpServletResponse response) {

		// 2. 쿠키생성
		Cookie nameCookie = new Cookie("name", "김현우");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-EEEE-hh:mm:ss");

		Cookie dateCookie = new Cookie("createDate", sdf.format(new Date()));

		// 3. 쿠키 생존시간 설정
		nameCookie.setMaxAge(60);
		dateCookie.setMaxAge(60);

		// 4. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(dateCookie);

		return "day1205/addResult";
	}// addCookie

	@GetMapping("/readCookie")
	public String readCookie(HttpServletRequest request, Model model) {

		// 2. 쿠키들 읽기
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			// 모든 쿠키를 반복한다.
			for (Cookie readCookie : cookies) {
				System.out.println(readCookie.getName() + readCookie.getValue());

				if ("name".equals(readCookie.getName())) {
					model.addAttribute("cookieName", readCookie.getValue());
				}

				if ("createDate".equals(readCookie.getName())) {
					model.addAttribute("cookieDate", readCookie.getValue());
				}
			}

			model.addAttribute("msg", "HttpServletRequest 사용");
		}
		return "day1205/readCookie";
	}// readCookie

	@GetMapping("/readCookie2")
	public String readCookie2(@CookieValue(value = "name", defaultValue = "홍길동") String name,
			@CookieValue(value = "createDate", required = false) String date, Model model) {

		System.out.println(name + " / " + date);

		model.addAttribute("cookieName", name);
		model.addAttribute("cookieDate", date);
		model.addAttribute("msg", "@CookieValue 사용");
		return "day1205/readCookie";
	}// readCookie2

}