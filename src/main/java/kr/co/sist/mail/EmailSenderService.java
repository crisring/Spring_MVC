package kr.co.sist.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import kr.co.sist.crypto.CryptoService;

@Service
public class EmailSenderService {

	public void mailSender(EmailVO eVO) throws IOException, MessagingException {

		String dir = System.getProperty("user.dir");

		// 1. Properties 생성 (서버에 연결할 ID와 비번을 가진 Properties)
		Properties prop = new Properties();

		// 2. HDD에 존재하는 properties 파일을 load (FileInputStream 사용)

		prop.load(new FileInputStream(dir + "/src/main/java/properties/email.properties"));

		// 3.이름을 사용하여 값 얻기
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		// SMTP설정 : Properties (인증외부, TLS보안, 호스트설정, 포트)
		Properties smtpProp = new Properties();
		smtpProp.put("mail.smtp.auth", "true");
		smtpProp.put("mail.smtp.starttls.enable", "true");
		smtpProp.put("mail.smtp.host", "smtp.naver.com");
		smtpProp.put("mail.smtp.port", "587");

		CryptoService cs = new CryptoService();

		// Session설정 : Session : Authenticator
		Session session = Session.getInstance(smtpProp, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(cs.decrypt(username), cs.decrypt(password));
			}

		});

		// 메일내용설정 : MimeMessage (메타정보설정(헤더에 값 설정) - 발신자, 수신자, 제목, 내용)
		Message message = new MimeMessage(session);

		// 발신자
		message.setFrom(new InternetAddress(cs.decrypt(username) + "@naver.com"));

		// 수신자
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(eVO.getEmail()));

		// 제목
		message.setSubject(eVO.getSubject());
		// 내용
		message.setContent(eVO.getContent(), "text/html;charset=UTF-8"); // HTML태그 전송

		// 전송 : Transport
		Transport.send(message);
		System.out.println("메일전송성공!");

	}

	public boolean sendPassword(String email) {

		boolean flag = false;

		String chars = "~!@qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

		char[] tempPass = new char[8];
		Random random = new Random();

		for (int i = 0; i < tempPass.length; i++) {
			tempPass[i] = chars.charAt(random.nextInt(chars.length()));
		}

		// 생성된 비번을 암호화하여 DB에 변경
		String pass = new String(tempPass);

		EmailVO eVO = new EmailVO();
		eVO.setEmail(email);
		eVO.setSubject("[sist.co.kr] 당신의 비밀번호가 초기화 되었습니다.");

		StringBuilder content = new StringBuilder();
		content.append(email).append("님 안녕하세요!<br>").append("당신의 비빌번호가 초기화되었음을 알려드립니다.<br>")
				.append("아래의 비밀번호로 로그인 하신 후 비밀번호를 재설정해주세요. <br>").append("문의사항이 있다면 sist_admin@sist.co.kr로 문의해주세요<Br>")
				.append("임시 비밀번호 : <Strong>").append(pass).append("</Strong>입니다!");

		eVO.setContent(content.toString());

		try {
			mailSender(eVO);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * EmailVO eVO = new EmailVO(1, "crisring7574@gmail.com", "메일 전송!",
	 * "<Strong>안녕하세요</Strong> <br> 생성된 비빌번호입니다.");
	 * 
	 * EmailSenderService ess = new EmailSenderService();
	 * 
	 * try { ess.mailSender(eVO); } catch (IOException e) { e.printStackTrace(); }
	 * catch (MessagingException e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
