package kr.co.sist.ajax;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AjaxService {

	public String createJson() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("name", "김현우");
		jsonObj.put("age", 24);

		JSONArray ja = new JSONArray();
		String[] hobbyArr = { "등산", "영화감상", "운동" };
		JSONObject jsonTemp = null;
		for (String hobby : hobbyArr) {
			jsonTemp = new JSONObject();
			jsonTemp.put("hobby", hobby);

			ja.add(jsonTemp);
		} // end for

		jsonObj.put("hobby", ja);
		jsonObj.put("resultFlag", !ja.isEmpty());

		return jsonObj.toJSONString();
	}// createJson

}
