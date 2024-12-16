package kr.co.sist.loginpractice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * output 형식을 저장
 */
@Getter
@Setter
@ToString
public class MemberDomain {

	private String member_id, name, phone_number, ip, address;

}
