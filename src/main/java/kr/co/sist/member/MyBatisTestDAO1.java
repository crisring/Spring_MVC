package kr.co.sist.member;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.dao.MyBatisHandler;

@Repository
public class MyBatisTestDAO1 {

	public List<Integer> selectAllEmpno() throws PersistenceException {

		MyBatisHandler mbh = MyBatisHandler.getInstance();

		List<Integer> list = null;

		SqlSession handler = mbh.getHandler();
		try {
			list = handler.selectList("kr.co.sist.member.selectEmpno");
		} finally {
			mbh.closeHandler(handler);
		}
		return list;

	}// selectAllEmpno

	public EmpDomain1 selectOneEmp(int empno) throws PersistenceException {

		MyBatisHandler mbh = MyBatisHandler.getInstance();

		EmpDomain1 ed = null;

		SqlSession handler = mbh.getHandler();
		try {
			ed = handler.selectOne("kr.co.sist.member.selectOneEmp", empno);
		} finally {
			mbh.closeHandler(handler);
		}
		return ed;

	}// selectOneEmp

	public static void main(String[] args) {
		MyBatisTestDAO1 dao = new MyBatisTestDAO1(); // 인스턴스 생성
		try {
			EmpDomain1 emp = dao.selectOneEmp(7521); // 비정적 메서드 호출
			System.out.println(emp);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
}
