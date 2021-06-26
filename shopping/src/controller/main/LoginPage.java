package controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginPage {
	public void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.login(userId);
		if (authInfo == null) {
			session.removeAttribute("pwFail");
			session.setAttribute("userFail", "아이디가 존재하지않습니다.");
		} else {
			session.removeAttribute("userFail");
			if (userPw.equals(authInfo.getUserPw())) {
				session.removeAttribute("pwFail");
				/// when before close web browser using // session store
				session.setAttribute("authInfo", authInfo);
				// autologin checkbox
				String autologin = request.getParameter("autologin");
				if (autologin != null && autologin.equals("auto")) {
					Cookie cookie = new Cookie("autoLogin", userId);
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 30 * 365);
					// cookie send to webBrowser
					response.addCookie(cookie);
				}
				// request make cookie
				String idStore = request.getParameter("idStore");

				if (idStore != null && idStore.equals("store")) {
					Cookie cookie = new Cookie("idStore", userId);
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 30 * 365);
					// cookie send to webBrowser
					response.addCookie(cookie);

				} else {
					Cookie cookie = new Cookie("idStore", userId);
					cookie.setPath("/");
					cookie.setMaxAge(0);
					// cookie send to webBrowser
					response.addCookie(cookie);
				}
			} else {

				session.setAttribute("pwFail", "비밀번호가 틀렸습니다..");
			}
		}
	}
}