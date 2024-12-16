package kr.co.sist.dao.mapper;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.dao.MyBatisHandler;

@Repository
public class MyBatisTestDAO {

	public List<Integer> selectAllEmpno() throws PersistenceException {

		MyBatisHandler mbh = MyBatisHandler.getInstance();

		List<Integer> list = null;

		SqlSession handler = mbh.getHandler();
		try {
			list = handler.selectList("kr.co.sist.mapper.selectEmpno");
		} finally {
			mbh.closeHandler(handler);
		}
		return list;

	}// selectAllEmpno

	public EmpDomain selectOneEmp(int empno) throws PersistenceException {

		MyBatisHandler mbh = MyBatisHandler.getInstance();

		EmpDomain ed = null;

		SqlSession handler = mbh.getHandler();
		try {
			ed = handler.selectOne("kr.co.sist.mapper.selectOneEmp", empno);
		} finally {
			mbh.closeHandler(handler);
		}
		return ed;

	}// selectOneEmp

	public static void main(String[] args) {
		MyBatisTestDAO dao = new MyBatisTestDAO(); // 인스턴스 생성
		try {
			EmpDomain emp = dao.selectOneEmp(7521); // 비정적 메서드 호출
			System.out.println(emp);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
}
