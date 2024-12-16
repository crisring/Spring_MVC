package kr.co.sist.loginpractice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * input 형식
 */
@Getter
@Setter
@ToString
public class MemberVO {

	private String id, password, name, phone_number, ip, address;

}
