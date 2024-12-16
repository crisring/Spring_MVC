package kr.co.sist.user.board;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MBoardDomain {
	private int num;
	private String subject, content, writer, ip;
	private Timestamp input_date;// 정밀한 시간을 사용하기위해서

}
