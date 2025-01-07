package kr.co.sist.mail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

	@Autowired
	private EmailSenderService ess;

	@GetMapping("/day1219/email")
	public String mailList(Model model) {

		List<String> mailList = new ArrayList<String>();

		mailList.add("crisring7574@gmail.com");

		model.addAttribute("revList", mailList);

		return "day1219/emailList";
	}

	@GetMapping("/day1219/mailSender")
	public String mailSender(String email, Model model) {

		model.addAttribute("result", ess.sendPassword(email));

		return "day1219/sendResult";

	}

}
