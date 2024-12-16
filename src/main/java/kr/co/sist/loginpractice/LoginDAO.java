package kr.co.sist.loginpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginDAO {

	@Bean
	public LoginDAO lDAO() {
		return new LoginDAO();
	}

	/*
	 * public int insertMember(Member1VO mVO) throws
	 * PersistenceExceptionTranslationAutoConfiguration {
	 * 
	 * int rowCnt = 0;
	 * 
	 * 
	 * 
	 * return rowCnt; }
	 */
}
