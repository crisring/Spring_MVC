package kr.co.sist.send_data;

import org.springframework.stereotype.Service;

@Service
public class DataService {

	public DataDomain searchData(int num) {
		DataDomain dd = null;

		switch (num) {
		case 1:
			dd = new DataDomain("김현우", 26);
			break;
		case 2:
			dd = new DataDomain("이인혁", 24);
			break;
		default:
			dd = new DataDomain("이일환", 27);
			break;
		}

		return dd;
	}

}
