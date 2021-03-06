package service.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;
import repository.LogInRepository;

public class CookieService {
	@Autowired
	LogInRepository logInRepository;
	public void getCookie(HttpServletRequest request) {
		
		//사용자로부터 쿠키를 받아옫나
		
		Cookie[] cookies=request.getCookies();
		if(cookies!=null &&cookies.length>0) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().startsWith("id")) {
					request.setAttribute("isId", cookie.getValue());
				}
				if(cookie.getName().startsWith("auto")) {
					String userId = cookie.getValue();
					AuthInfoDTO authInfo = logInRepository.logIn(userId);
					HttpSession session=request.getSession();
					session.setAttribute("authInfo", authInfo);
				}
			}
		}
			
	}
}
