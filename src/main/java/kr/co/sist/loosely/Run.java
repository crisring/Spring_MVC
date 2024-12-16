package kr.co.sist.loosely;

public class Run {

	public static void main(String[] args) {

		// 의존성 주입을 관리하는 클래스 사용
		Assembly as = new Assembly();

		// 의존성 주입받을 객체 얻기
		Service service = as.getBean();

		// 의존성 주입받은 객체가 제공하는 기능을 사용
		String name = "김현우";
		if (service.add(name)) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		System.out.println(service.search());
	}// mains

}
