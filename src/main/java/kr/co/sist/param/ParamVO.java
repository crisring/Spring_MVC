package kr.co.sist.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ParamVO {

	private String name;
	private int age;
	private String[] addr;
	private String ip;
	private String userAgent;

}
