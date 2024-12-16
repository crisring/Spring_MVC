package kr.co.sist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sist.interceptor.MyInterceptor;
import kr.co.sist.interceptor.MyInterceptor2;

// conponent보다 먼저 만들어짐
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	// 개발자 만든 interceptor를 의존성 주입받는다.
	@Autowired
	private MyInterceptor myInterceptor;

	// 여러 개의 interceptor를 의존성 주입
	@Autowired
	private MyInterceptor2 myInterceptor2;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor) // 개발자가 만든 interceptor를 등록
				.addPathPatterns("/**") // /** 이URL의 하위 URL에서 모두 동작, /는 최상위만 동작
				.excludePathPatterns("/day1205/**", "/day1206/**", "/day1212/crypto"); // 제외될 URI

		/*
		 * registry.addInterceptor(myInterceptor2) // 개발자가 만든 interceptor를 등록
		 * .addPathPatterns("/**") // /** 이URL의 하위 URL에서 모두 동작, /는 최상위만 동작
		 * .excludePathPatterns("/day1205/**", "/day1206/**", "/day1212/crypto"); // 제외될
		 * URI
		 */
	}

}
