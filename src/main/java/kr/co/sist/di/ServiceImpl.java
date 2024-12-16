package kr.co.sist.di;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// @Scope("prototype")
@Service
public class ServiceImpl {

	@Autowired
	@Qualifier("diDAO")
	private OracleDAOImpl dao;
	// private DAO dao;

	public boolean add(String name) {
		boolean flag = false;

		System.out.println("의존성 주입받은 객체 : " + dao);
		try {
			flag = dao.insert(name) == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	public List<String> search() {

		System.out.println("의존성 주입받은 객체 : " + dao);
		List<String> list = null;

		// 의존성 주입받은 객체를 사용
		try {
			list = dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
