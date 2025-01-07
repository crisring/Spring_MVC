package kr.co.sist.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestLoadProperties {

	public static void main(String[] args) {

		try {
			System.out.println(System.getProperty("user.dir"));
			String dir = System.getProperty("user.dir");

			// 1. Properties 생성
			Properties prop = new Properties();

			// 2. HDD에 존재하는 properties 파일을 load (File input Stream 사용)

			prop.load(new FileInputStream(dir + "/src/main/java/properties/email.properties"));

			// 3.이름을 사용하여 값 얻기
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			System.out.println(username + "/" + password);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
