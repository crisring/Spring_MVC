package kr.co.sist.loosely;

/**
 * 의존성 주입할 객체를 생성하여, 의존성 주입 받을 객체에 할당하고, <br>
 * 의존성 주입받은 객체를 반환 하는 일 <br>
 * Spring Framework에서 생성하는 객체를 bean이라고 한다.
 */
public class Assembly {

	public Service getBean() {
		// 1. 의존성 주입할 객체 생성
		DAO dao = new OracleDAOImpl();

		// 2. 의존성 주입 받을 객체 생성
		Service service = new ServiceImpl(dao);

		// 3. 의존성 주입받은 객체를 반환
		return service;

	}
}
