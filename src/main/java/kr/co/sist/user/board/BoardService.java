package kr.co.sist.user.board;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

//	@Autowired(required = false)
//	private BoardDAO bDAO;

	/**
	 * 1.총 레코드 수 구하기
	 * 
	 * @param sVO
	 * @return
	 */
	public int totalCount(SearchVO sVO) {
		int cnt = 0;
		try {
			cnt = BoardDAO.getInstance().selectTotalCount(sVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return cnt;
	}// totalCount

	/**
	 * 2.한 화면에 보여줄 레코드의 수
	 * 
	 * @return
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}// pageScacle

	/**
	 * 3.총 페이지 수
	 * 
	 * @param totalCount
	 * @param pageScale
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		int totalPage = (int) Math.ceil((double) totalCount / pageScale);
		return totalPage;
	}

	/**
	 * 현재 페이지 번호
	 * 
	 * @param paramPage
	 * @return
	 */
	public int currentPage(String paramPage) {
		int currentPage = 1;
		if (paramPage != null) {
			try {
				currentPage = Integer.parseInt(paramPage);
			} catch (NumberFormatException nfe) {
			} // end catch
		} // end if
		return currentPage;
	}

	/**
	 * 4.검색의 시작번호를 구하기
	 * 
	 * @param paramPage
	 * @param pageScale
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		int startNum = currentPage * pageScale - pageScale + 1;// 시작번호
		return startNum;
	}// startNum

	/**
	 * 5. 끝번호
	 * 
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = startNum + pageScale - 1; // 끝 번호
		return endNum;
	}// endNum

	public List<MBoardDomain> searchBoard(SearchVO sVO) {
		List<MBoardDomain> list = null;

		try {
			list = BoardDAO.getInstance().selectBoard(sVO);

			// 업무로직 처리
			String tempSubject = "";
			for (MBoardDomain tempVO : list) {
				tempSubject = tempVO.getSubject();
				if (tempSubject.length() > 30) {
					tempVO.setSubject(tempSubject.substring(0, 29) + "...");
				}
			} // end for

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return list;
	}// searchBoard

	public String writeBoard(MBoardVO mbVO) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("writeFlag", false);

		try {
			int rowCnt = BoardDAO.getInstance().insertBoard(mbVO);
			jsonObj.put("writeFlag", rowCnt == 1);
			jsonObj.put("writeCount", rowCnt);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return jsonObj.toJSONString();
	}// writeBoard

	public MBoardDomain searchDetailBoard(int num) {
		MBoardDomain mbDomain = null;

		try {
			mbDomain = BoardDAO.getInstance().selectDetailBoard(num);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return mbDomain;
	}// searchDetailBoard

	public String modifyBoard(MBoardVO mbVO) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("modifyFlag", false);

		try {
			int rowCnt = BoardDAO.getInstance().updateBoard(mbVO);
			jsonObj.put("modifyFlag", rowCnt == 1);
			jsonObj.put("modifyCount", rowCnt);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return jsonObj.toJSONString();
	}// modifyBoard

	public String removeBoard(MBoardVO mbVO) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("removeFlag", false);

		try {

			int cnt = BoardDAO.getInstance().deleteBoard(mbVO);
			jsonObj.put("removeFlag", cnt == 1);
			jsonObj.put("removeCount", cnt);

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		return jsonObj.toJSONString();
	}// removeBoard

}// class
