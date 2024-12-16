package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.List;

/**
 * 업무의 구현
 */
public class ServiceImpl implements Service {

	private DAO dao;

	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean add(String name) {
		boolean flag = false;

		try {
			flag = dao.insert(name) == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public List<String> search() {

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
