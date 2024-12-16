package kr.co.sist.di;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 구현 클래스
 */
// @Component("looslyDAO")
public class MySqlDAOImpl implements DAO {

	/*
	 * public MySqlDAOImpl() { System.out.println("MySqlDAOImpl의 기본생성자"); }//
	 * MySqlDAOImpl
	 */
	public int insert(String name) throws SQLException {
		int cnt = new Random().nextInt(2);
		System.out.println("MySql DBMS에 " + name + "이 insert " + (cnt == 0 ? "실패" : "성공"));
		return 1;
	}

	public List<String> select() throws SQLException {
		List<String> list = new ArrayList<String>();
		list.add("한강 스페셜 에디션");
		list.add("소년이 운다.");
		list.add("트럼프와 함께하는 알트코인 대폭등");
		list.add("서랍에 저녁을 누워드렸다");

		return list;
	}

}
