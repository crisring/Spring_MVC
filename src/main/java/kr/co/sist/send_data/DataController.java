package kr.co.sist.send_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {

//	미친 서비스 싱글톤 만들기
	@Autowired(required = false)
	private DataService ds;

	@RequestMapping(value = "/day1202/send_data", method = RequestMethod.GET)
	public String sendList() {

		return "/day1202/data_list";
	}// sendList

	@GetMapping("/day1202/useModel")
	public String useModel(int num, Model model, HttpServletRequest request) {

		DataDomain dd = ds.searchData(num);

		// 업무처리 결과를 view로 전달하기위해 scope객체 대신 Model을 사용
		model.addAttribute("data", dd);
		model.addAttribute("msg", "Model인터페이스로 처리");
		model.addAttribute("userAgent", request.getHeader("User-Agent"));

		return "/day1202/data_result";
	}// useModel

	@RequestMapping(value = "/day1203/useRequest", method = RequestMethod.GET)
	public String useRequest(int num, HttpServletRequest request) {

		DataDomain dd = ds.searchData(num);

		request.setAttribute("data", dd);
		request.setAttribute("msg", "request로 처리");
		request.setAttribute("userAgent", request.getHeader("User-Agent"));

		return "/day1202/data_result";
	}// useRequest

	@RequestMapping(value = "/day1203/useModelAndView", method = RequestMethod.GET)
	public ModelAndView useModelAndView(@RequestParam(value = "numTest", defaultValue = "1") int num,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/day1202/data_result");

		DataDomain dd = ds.searchData(num);

		mav.addObject("data", dd);
		mav.addObject("msg", "ModelAndView로 처리");
		mav.addObject("userAgent", request.getHeader("User-Agent"));

		return mav;

	}// useModelAndView

}
// class
