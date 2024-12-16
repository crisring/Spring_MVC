package kr.co.sist.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@Autowired(required = false)
	private AjaxService as;

//	@GetMapping("/day1211/useResponsebody")
	@RequestMapping(value = "/day1211/useResponsebody", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String useResponseBody() {
		String jsonObj = "";

		jsonObj = as.createJson();

		return jsonObj;
	}// useResponseBody

}
