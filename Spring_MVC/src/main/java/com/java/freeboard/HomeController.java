package com.java.freeboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 컨트롤러는 대문급이다.
 * 이 대문 처리를 간단하게 처리할지(서비스 영역으로 넘기기),
 * 아니면 서비스를 컨트롤러에서 다룰지(복잡하게)는 개발자의 개인차이임.
 * 
 * 웹컨테이너는 3가지로 이루어져 있다.
 * 흐름도 : 
 * 컨트롤러 -> 서비스 -> 매퍼로 이루어져 있다. -> mybatis -> 연동되어있는 jdbc로 보냄
 */

/**
 * Handles requests for the application home page.
 */
@Controller
/*
 * 어노테이션은 스프링이 무시하지 않는 주석이다.
 */
public class HomeController {
	// logger를 불러오는 수식
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	/*
	 * ★★★ 요청을 받을때 이곳에서 get방식, post방식을 결정한다.
	 * @RequestMapping(value = "/", method = RequestMethod.GET) // 한가지 방식으로만 받고싶을때
	 * RequestMapping - value에 어떤 값을 입력할 경우 / 아래 있는 것이 실행이 된다.
	 */
	public String home(Locale locale, Model model) {
		/*
		 * ★★★ Model - 담아주는 주머니 역활, key와 값으로 구분이 되는데 ("ServerTime" - 키, formatteDate - 값)
		 * 이것을 Model단에 담겨져있는 것을 다 꺼낼 수 있음
		 */
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		/*
		 * Return 값으로 home을 가르킨다. home.jsp파일(View파일)
		 * WEB-INF/spring/appServlet/servlet-context.xml 파일 아래 정의되어 있다.
		 */
	}
	
}
