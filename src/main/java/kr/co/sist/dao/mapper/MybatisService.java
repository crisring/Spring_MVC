package kr.co.sist.dao.mapper;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisService {

	@Autowired(required = false)
	private MyBatisTestDAO mbtDAO;

	public List<Integer> searchAllEmpno() {

		List<Integer> list = null;

		try {
			list = mbtDAO.selectAllEmpno();

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}// searchAllEmpno

	public String searchOneEmp(int empno) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("resultFlag", false);

		EmpDomain ed = null;

		try {
			ed = mbtDAO.selectOneEmp(empno);
			jsonObj.put("resultFlag", ed != null);
			jsonObj.put("ename", ed.getEname());
			jsonObj.put("sal", ed.getSal());
			jsonObj.put("job", ed.getJob());
			// jsonObj.put("hiredate", ed.getHiredate()); 날짜 String으로 변경 후 추가
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			jsonObj.put("hiredate", sdf.format(ed.getHiredate()));

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return jsonObj.toJSONString();
	}// searchOneEmp

}
