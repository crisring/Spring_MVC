package kr.co.sist.crypto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptoService {

	/**
	 * BCrypt를 사용한 일방향 해쉬
	 * 
	 * @param pass 해쉬할 일반 문자열의 비번
	 * @return 해쉬된 비번
	 */
	public String sha(String pass) {
		String encodingPass = "";

		// 1. 생성
		PasswordEncoder pe = new BCryptPasswordEncoder();

		// 2. 암호문 변환
		encodingPass = pe.encode(pass);

		return encodingPass;
	}

	/**
	 * 암호화 : 입력값을 데이터 베이스에 추가, 변경 할 때 사용
	 * 
	 * @param plainText
	 * @return
	 */
	public String encrypt(String plainText) {

		String encptText = "";
		String key = "sist1234";
		String salt = "12345678"; // 암호화 강도 조절

		// 1. 암호화 객체 생성
		TextEncryptor te = Encryptors.text(key, salt);

		// 2. 암호화
		encptText = te.encrypt(plainText);

		return encptText;
	}// encrypt

	/**
	 * 복호화
	 * 
	 * @param plainText
	 * @return
	 */
	public String decrypt(String cipherText) {

		String decptText = "";
		String key = "sist1234";
		String salt = "12345678"; // 암호화 강도 조절

		// 1. 암호화 객체 생성
		TextEncryptor te = Encryptors.text(key, salt);

		// 2. 복호화
		decptText = te.decrypt(cipherText);

		return decptText;
	}// decrypt

}
