package kr.co.sist.loosely;

import java.util.List;

/**
 * 업무 목록을 기술
 */
public interface Service {

	public boolean add(String name);

	public List<String> search();

}
