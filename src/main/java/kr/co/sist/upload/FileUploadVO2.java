package kr.co.sist.upload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class FileUploadVO2 {

	// 주의할점 : HTML Form Control명과 일치
	private String uploader;
	private String[] targetAge, fileNames;
}
