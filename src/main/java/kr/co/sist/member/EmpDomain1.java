package kr.co.sist.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpDomain1 {

	private int empno, sal, comm, mgr, deptno;
	private String ename, job;
	private Date hiredate;

}
