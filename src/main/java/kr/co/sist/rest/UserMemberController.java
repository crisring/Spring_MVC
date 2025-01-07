package kr.co.sist.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // 모든 응답은 JSP가 아닌 내용 자체가 응답된다. @ResponceBody를 사용한 것과 동일
@RequestMapping("/restful/users")
public class UserMemberController {

	@Autowired(required = false)
	private UserMemberService ums;

	private Map<String, String> userMap = new HashMap<String, String>();

	@PostMapping
	public String createUser(@RequestParam String userId, @RequestParam String userName) {

		String jsonObj = ums.addMember(userMap, userId, userName);

		return jsonObj;
	}

	@GetMapping("/{userId}")
	public String getUser(@PathVariable String userId) {

		String jsonObj = ums.searchMember(userMap, userId);

		return jsonObj;
	}

	@GetMapping("/all")
	public String getAllUser() {

		String jsonObj = ums.searchAllMember(userMap);

		return jsonObj;
	}// getAllUser

	@PutMapping("/{userId}")
	public String modifyUser(@PathVariable String userId, @RequestParam String userName) {

		String jsonObj = ums.modifyMember(userMap, userId, userName);

		return jsonObj;
	}

	@DeleteMapping("/{userId}")
	public String removeUser(@PathVariable String userId) {

		String jsonObj = ums.removeMember(userMap, userId);

		return jsonObj;
	}

}
