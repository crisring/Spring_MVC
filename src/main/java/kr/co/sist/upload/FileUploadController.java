package kr.co.sist.upload;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@GetMapping("/day1206/fileuploadFrm")
	public String uploadFrm() {
		return "day1206/uploadFrm";
	}

	private String uploadDir = "C:/dev/workspace_spring/mvc/src/main/resources/static/upload";

	@PostMapping("/day1206/uploadProcess")
	public String uploadProcess(@RequestParam("upfile") MultipartFile mf, Model model, FileUploadVO fuVO)
			throws Exception {

		String resultPage = "day1206/uploadResult";

		int maxSize = 1024 * 1024 * 5;

		if (maxSize < mf.getSize()) {
			throw new Exception("업로드 파일의 크기는 최대 5MBYTE까지만 가능합니다.");
		}

		// 중복파일의 처리
		// 1. 업로드된 파일명 받기
		String originalFilename = mf.getOriginalFilename();

		// 2. 파일명으로 파일을 생성
		File uploadFile = new File(uploadDir + "/" + originalFilename);

		// 3. 확장자를 기준으로 파일명을 나눈다.
		String fileName = "";
		String fileExt = "";
		if (originalFilename.contains(".")) {
			fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
			fileExt = originalFilename.substring(originalFilename.lastIndexOf("."));
		}

		// 4. 같은 이름의 파일이 존재하면 파일명과 .사이에 _1카운트를 붙인다.
		int cnt = 1;
		StringBuilder newFileName = new StringBuilder();

		while (uploadFile.exists()) {
			newFileName.append(fileName).append("_").append(cnt).append(fileExt);
			uploadFile = new File(uploadDir + "/" + newFileName.toString());
			cnt++;
			newFileName.delete(0, newFileName.length());
		}

		// 5. 업로드 수행
		mf.transferTo(uploadFile);

		fuVO.setFileName(uploadFile.getName());

		model.addAttribute("msg", mf.getOriginalFilename() + "(" + mf.getSize() + "byte)가 업로드 되었습니다.");
		/*
		 * System.out.println("MIME_TYPE : " + mf.getContentType());
		 * System.out.println("form_control : " + mf.getName());
		 * System.out.println("파일명 : " + mf.getOriginalFilename());
		 * System.out.println("파일크기 : " + mf.getSize()); System.out.println("파일유무 : " +
		 * mf.isEmpty());
		 * 
		 * if (mf.getContentType().contains("image")) {
		 * 
		 * }
		 */

		System.out.println(fuVO);
		return resultPage;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView uploadErr(Exception e) {

		e.printStackTrace();
		ModelAndView mav = new ModelAndView("day1206/uploadErr");

		mav.addObject("errMsg", e.getMessage());

		return mav;
	}

	@GetMapping("/day1206/fileuploadFrm2")
	public String uploadFrm2() {
		return "day1206/uploadFrm2";
	}

	@PostMapping("/day1206/uploadProcess2")
	public String uploadProcess2(@RequestParam("upfile") List<MultipartFile> list, Model model, FileUploadVO2 fuVO)
			throws Exception {

		String resultPage = "day1206/uploadResult2";

		int fileCnt = 0;
		String[] fileNames = new String[list.size()];
		String[] viewFilesNames = new String[list.size()];

		for (MultipartFile mf : list) {

			int maxSize = 1024 * 1024 * 5;

			if (maxSize < mf.getSize()) {
				throw new Exception("업로드 파일의 크기는 최대 5MBYTE까지만 가능합니다.");
			}

			// 중복파일의 처리
			// 1. 업로드된 파일명 받기
			String originalFilename = mf.getOriginalFilename();

			viewFilesNames[fileCnt] = originalFilename;

			// 2. 파일명으로 파일을 생성
			File uploadFile = new File(uploadDir + "/" + originalFilename);

			// 3. 확장자를 기준으로 파일명을 나눈다.
			String fileName = "";
			String fileExt = "";
			if (originalFilename.contains(".")) {
				fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
				fileExt = originalFilename.substring(originalFilename.lastIndexOf("."));
			}

			// 4. 같은 이름의 파일이 존재하면 파일명과 .사이에 _1카운트를 붙인다.
			int cnt = 1;
			StringBuilder newFileName = new StringBuilder();

			while (uploadFile.exists()) {
				newFileName.append(fileName).append("_").append(cnt).append(fileExt);
				uploadFile = new File(uploadDir + "/" + newFileName.toString());
				cnt++;
				newFileName.delete(0, newFileName.length());
			}

			// 5. 업로드 수행
			mf.transferTo(uploadFile);

			fileNames[fileCnt] = uploadFile.getName();

			model.addAttribute("msg", mf.getOriginalFilename() + "(" + mf.getSize() + "byte)가 업로드 되었습니다.");

			fileCnt++;
		}

		model.addAttribute("fileName", viewFilesNames);
		fuVO.setFileNames(fileNames);
		System.out.println(fuVO);
		return resultPage;
	}// uploadProcess2

}
