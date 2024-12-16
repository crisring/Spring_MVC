package kr.co.sist.loginpractice;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import kr.co.sist.chipher.DataDecryption;
import kr.co.sist.chipher.DataEncryption;

@Service
public class LoginService {

	/**
	 * 개인정보 암호화
	 * 
	 * @param mVO
	 */
	public void setEncryption(MemberVO mVO) {
		DataEncryption de = new DataEncryption("abcdef0123456789");

		// 단방향 Hash -> 중요도가 더 높다.
		try {
			mVO.setPassword(DataEncryption.messageDigest("SHA-1", mVO.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 양방향 Hash
		try {
			mVO.setAddress(de.encrypt(mVO.getAddress()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// setEncryption

	/**
	 * 개인정보 복호화
	 */
	public void getDecryption(MemberVO mVO) {

		DataDecryption dd = new DataDecryption("abcdef0123456789");

		// 양방향 Hash 복호화
		try {
			// mVO.setPassword(dd.decrypt(mVO.getPassword()));
			mVO.setAddress(dd.decrypt(mVO.getAddress()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// getDecryption

}
