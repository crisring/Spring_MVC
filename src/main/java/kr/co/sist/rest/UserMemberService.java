package kr.co.sist.rest;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class UserMemberService {

	// 추가 : POST
	public String addMember(Map<String, String> userMap, String userId, String userName) {

		boolean flag = !userMap.containsKey(userId);

		if (flag) {
			// 입력된 Map에 추가
			userMap.put(userId, userName);
		}

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("addFlag", flag);

		return jsonObj.toJSONString();

	}// addMember

	public String searchMember(Map<String, String> userMap, String userId) {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("searchFlag", userMap.containsKey(userId));
		// jsonObj.put("userName", userMap.get(userId)==null?"아이디가 존재하지
		// 않음":userMap.get(userId));
		jsonObj.put("userName", userMap.getOrDefault(userId, "아이디가 존재하지 않음")); // 존재하면 id, 아니면 문장출력

		return jsonObj.toJSONString();
	}// searchMember

	public String searchAllMember(Map<String, String> userMap) {
		JSONObject jsonObj = new JSONObject();

		boolean flag = !userMap.isEmpty();

		jsonObj.put("resultFlag", flag);
		jsonObj.put("dataSize", userMap.size());

		if (flag) {

			JSONArray jsonArr = new JSONArray();
			JSONObject jsonTemp = null;

			for (String key : userMap.keySet()) {
				jsonTemp = new JSONObject();
				jsonTemp.put("userId", key);
				jsonTemp.put("userName", userMap.get(key));

				jsonArr.add(jsonTemp);
			}

			jsonObj.put("data", jsonArr);

		}

		return jsonObj.toJSONString();
	}

	public String modifyMember(Map<String, String> userMap, String userId, String userName) {
		JSONObject jsonObj = new JSONObject();

		boolean flag = userMap.containsKey(userId);

		if (flag) {
			userMap.put(userId, userName);
		}

		jsonObj.put("resultFlag", flag);

		return jsonObj.toJSONString();
	}

	public String removeMember(Map<String, String> userMap, String userId) {
		JSONObject jsonObj = new JSONObject();

		boolean flag = userMap.containsKey(userId);

		if (flag) {
			userMap.remove(userId);
		}

		jsonObj.put("removeFlag", flag);

		return jsonObj.toJSONString();
	}
}
