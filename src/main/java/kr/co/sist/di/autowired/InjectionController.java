package kr.co.sist.di.autowired;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InjectionController {

	@Autowired(required = false)
	private TestService ts;

	// 설정파일에 있는 값을 얻기
	@Value("${prgData.version}")
	private String version;

	@Value("${prgData.devName}")
	private String devName;

	@Value("${prgData.pubDate}")
	private String pubDate;

	@GetMapping("/day1210/injectionTest")
	public String injectionTest(Model model) {

		/*
		 * System.out.println(version); System.out.println(devName);
		 * System.out.println(pubDate);
		 */

		if (devName != null && !devName.isEmpty()) {
			try {
				devName = URLDecoder.decode(URLEncoder.encode(devName, "8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}

		model.addAttribute("objMsg", ts.work());
		model.addAttribute("version", version);
		model.addAttribute("devName", devName);
		model.addAttribute("pubDate", pubDate);

		return "day1210/injectionResult";
	}

}
