package kr.co.sist.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor2 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("2-1. preHandle 호출 : HandlerMapper가 호출되기 전 실행");
		System.out.println("요청URI : " + request.getRequestURI());

		// true가 반환되면 이후 모든 작업이 수행
		// false가 반환되면 이후 작업이 처리되지 않는다. -> 사용자가 받을 페이지가 없다.

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("2-2. postHandle 호출 : View(JSP)가 랜더링되기 전 실행");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("2-3. afterCompletion 호출 : 응답되기 전 호출");
		System.out.println("응답결과 : " + response.getStatus());

	}

}
