package kr.co.sist.webutils;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WebUtilsController {

	// WebUtils를 사용한 session, cookie 값 받기
	// 1. HttpServletRequest를 매개변수로 선언
	@GetMapping("/day1205/webutils")
	public String useWebUtils(HttpServletRequest request) {

		// 2. 세션 값 받기(name, data[])
		String name = (String) WebUtils.getSessionAttribute(request, "name");
		String[] data = (String[]) WebUtils.getSessionAttribute(request, "data");

		// 3. 쿠키 값 받기(name, createDate)
		String cookieName = "";
		String cookieDate = "";

		Cookie nameCookie = WebUtils.getCookie(request, "name");
		Cookie dateCookie = WebUtils.getCookie(request, "createDate");

		if (nameCookie != null) {
			cookieName = nameCookie.getValue();
		}

		if (dateCookie != null) {
			cookieDate = dateCookie.getValue();
		}

		System.out.println("세션 : " + name + " / " + Arrays.toString(data));
		System.out.println("쿠키 : " + cookieName + " / " + cookieDate);

		return "day1205/webutils_result";
	}

}
