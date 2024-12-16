package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.List;

/**
 * DBMS 업무 목록을 기술
 */
public interface DAO {

	public int insert(String name) throws SQLException;

	public List<String> select() throws SQLException;

}
