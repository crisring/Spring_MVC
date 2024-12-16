package kr.co.sist.crypto;

import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sist.user.board.MBoardVO;

@Controller
public class CryptoController {

	@Autowired
	private CryptoService cs;

	@GetMapping("/day1212/crypto")
	public String inputFrm() {
		return "day1212/inputFrm";
	}// inputFrm

	@PostMapping("/day1212/cryptoProcess")
	public String inputData(MBoardVO mbVO, Model model) {

		// 암호화
		mbVO.setPass(cs.sha(mbVO.getPass()));
		mbVO.setWriter(cs.encrypt(mbVO.getWriter()));

		// 복호화 (비번은 복호화할 수 없다.)
		String writer = cs.decrypt(mbVO.getWriter());
		model.addAttribute("mbVO", mbVO);
		model.addAttribute("writer", writer);
		/*
		 * String plainText = mbVO.getWriter(); String cihperText =
		 * cs.encrypt(plainText); String cihperText2 = cs.encrypt(plainText);
		 * System.out.println("평문 : " + plainText); System.out.println("암호문 : " +
		 * cihperText);
		 * 
		 * String plainText2 = cs.decrypt(cihperText); String plainText3 =
		 * cs.decrypt(cihperText2); System.out.println("복호화 평문 : " + plainText2);
		 * System.out.println("복호화 평문 : " + plainText3);
		 * 
		 * String pass = mbVO.getPass(); String passEncoding = cs.sha(pass);
		 * 
		 * System.out.println("입력한 비번 : " + pass); System.out.println("encoding된 비번 : "
		 * + passEncoding);
		 * 
		 * String passEncoding1 = cs.sha(pass); System.out.println("encoding된 비번 : " +
		 * passEncoding1);
		 * 
		 * // 비교 PasswordEncoder pe = new BCryptPasswordEncoder();
		 * System.out.println(pe.matches(passEncoding, passEncoding1));
		 */

		return "day1212/cryptoResult";
	}// inputData

}
