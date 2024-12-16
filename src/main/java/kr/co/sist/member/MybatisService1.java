package kr.co.sist.member;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MybatisService1 {

	@Autowired(required = false)
	private MyBatisTestDAO1 mbtDAO;

	public List<Integer> searchAllEmpno() {

		List<Integer> list = null;

		try {
			list = mbtDAO.selectAllEmpno();

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}// searchAllEmpno

	public String searchOneEmp(int empno) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("resultFlag", false);

		EmpDomain1 ed = null;

		try {
			ed = mbtDAO.selectOneEmp(empno);
			String ename = encrypt(ed.getEname());
			String job = encrypt(ed.getJob());

			jsonObj.put("resultFlag", ed != null);
			jsonObj.put("ename", ename);
			jsonObj.put("sal", ed.getSal());
			jsonObj.put("job", job);
			// jsonObj.put("hiredate", ed.getHiredate()); 날짜 String으로 변경 후 추가
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			jsonObj.put("hiredate", sdf.format(ed.getHiredate()));

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return jsonObj.toJSONString();
	}// searchOneEmp

	public String sha(String pass) {

		String shaPass = "";

		PasswordEncoder pe = new BCryptPasswordEncoder();

		shaPass = pe.encode(pass);

		return shaPass;
	}// sha

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
