package kr.co.sist.user.board;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sist.util.BoardUtil;

@Controller
public class BoardController {

	@Autowired(required = false)
	private BoardService bs;

	@Autowired
	private BoardUtil bu;

	@RequestMapping(value = "/board/board_list", method = { GET, POST })
	public String boardList(SearchVO sVO, @RequestParam(value = "currentPage", defaultValue = "1") String paramPage,
			Model model) {

		// 게시판 리스트 구현
		// 1.총 레코드 수 구하기
		int totalCount = bs.totalCount(sVO);// 총 레코드 수

		// 2.한 화면에 보여줄 레코드의 수
		int pageScale = bs.pageScale();

		// 3.총 페이지 수
		int totalPage = bs.totalPage(totalCount, pageScale);

		// 4.검색의 시작번호를 구하기 ( pagination의 번호) [1][2][3]
		// String paramPage=request.getParameter("currentPage");

		int currentPage = bs.currentPage(paramPage);

		int startNum = bs.startNum(currentPage, pageScale);
		// 5. 끝번호
		int endNum = bs.endNum(startNum, pageScale);

		sVO.setCurrentPage(currentPage);
		sVO.setStartNum(startNum);
		sVO.setEndNum(endNum);
		sVO.setTotalPage(totalPage);
		sVO.setTotalCount(totalCount);

		List<MBoardDomain> listBoard = null;
		listBoard = bs.searchBoard(sVO); // 시작번호, 끝 번호를 사용한 게시글 조회

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
//		pageContext.setAttribute("startNum", startNum);
//		pageContext.setAttribute("endNum", endNum); 
		model.addAttribute("listBoard", listBoard);

		// 이동 url 설정
		sVO.setUrl("/board/board_list");
		// 페이지네이션 생성
		String pagination = bu.pagination(sVO);
		model.addAttribute("pagination", pagination);

		return "board/board_list";
	}// boardList

	@GetMapping("/board/board_detail")
	public String boardDetail(@RequestParam(value = "num") String tempNum,
			@RequestParam(defaultValue = "1") String currentPage, Model model) {

		String movePage = "board/board_detail";
		// 실제 글의 고유 번호를 받는다.
		int num = 0;
		try {
			num = Integer.parseInt(tempNum);
		} catch (NumberFormatException nfe) {
			movePage = "redirect:/board/board_list";
		} // end catch

		// 입력된 글 번호로 상세조회 수행.
		MBoardDomain mbd = bs.searchDetailBoard(num);
		model.addAttribute("mbd", mbd);

		return movePage;
	}// boardDetail

	@GetMapping("/board/board_write_frm")
	public String boardWriteFrm(Model model, HttpServletRequest request) {

		String movePage = "board/board_write_frm";
		String ip = request.getRemoteAddr();

		model.addAttribute("ip", ip);

		return movePage;
	}// boardDetail

	@PostMapping("/board/board_modify")
	@ResponseBody
	public String boardUpdate(MBoardVO mbVO) {
		String jsonObj = "";

		jsonObj = bs.modifyBoard(mbVO);

		return jsonObj;
	}// boardUpdate

	@PostMapping("/board/board_remove")
	@ResponseBody
	public String boardRemove(MBoardVO mbVO) {
		String jsonObj = "";

		jsonObj = bs.removeBoard(mbVO);

		return jsonObj;
	}// boardRemove

	@PostMapping("/board/board_write")
	@ResponseBody
	public String boardWrite(MBoardVO mbVO) {
		String jsonObj = "";

		jsonObj = bs.writeBoard(mbVO);

		return jsonObj;
	}// boardWrite

}
