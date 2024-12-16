package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 구현 클래스
 */
@Repository()
public class OracleDAOImpl implements DAO {

	@Override
	public int insert(String name) throws SQLException {
		System.out.println("Oracle DBMS에 " + name + "이 insert되었음");
		return 1;
	}

	@Override
	public List<String> select() throws SQLException {
		List<String> list = new ArrayList<String>();
		list.add("이것이 자바다");
		list.add("리눅스 입문자를 위한 명령어사전");
		list.add("JSP&amp;Servlet");
		list.add("데이터 베이스 개론과 실습");
		list.add("HTML5프로그래밍 입문");

		return list;
	}

}
