package kr.co.sist.di.autowired;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	// field injection
	// @Autowired(required = false)
	private TestDAO tDAO;

	// constructor injection
	// @Autowired(required = false)
	public TestService(TestDAO tDAO) {
		this.tDAO = tDAO;
	}

	// method 의존성 주입
	// @Autowired(required = false)
	public void settDAO(TestDAO tDAO) {
		System.out.println("setter method 의존성 주입");
		this.tDAO = tDAO;
	}

	public TestDAO gettDAO() {
		return tDAO;
	}

	public String work() {
		return tDAO.toString();

	}

}
