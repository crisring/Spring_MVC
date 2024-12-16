package kr.co.sist.exception;

import java.sql.SQLException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping(value = "/day1205/exception")
	public String work() throws ClassNotFoundException {

		if (new Random().nextBoolean()) {
			throw new ClassNotFoundException("예외가 발생했습니다");

		}
		System.out.println("정상작동");
		return "day1205/exception";
	}// work

	@RequestMapping(value = "/day1205/exception2")
	public String work2() throws SQLException {

		if (new Random().nextBoolean()) {
			throw new SQLException("work2 예외가 발생했습니다");

		}
		System.out.println("정상작동");
		return "day1205/exception";
	}// work2

	// Exception은 맞춰서 설정 - Reflaction : 실행 될때(runtime) 클래스, method, field 등의 정보를
	// 동적으로 조회하거나 조작하는 기능
	@ExceptionHandler({ ClassNotFoundException.class, SQLException.class })
	public ModelAndView exceptionHandle(Exception e) {

		// 2. ModelAndView 생성
		ModelAndView mav = new ModelAndView();

		// 3. 예외가 발생했을때 보여줄 페이지 설정
		mav.setViewName("day1205/err");
		e.printStackTrace();

		// 4. 예외 메시지 설정
		mav.addObject("errmsg", e.getMessage());

		return mav;
	}

}
