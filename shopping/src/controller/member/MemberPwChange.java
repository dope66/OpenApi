package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;

public class MemberPwChange {
	public int pwChange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId=authInfo.getUserId();
		String memPw=request.getParameter("newPw");
		
		if (request.getParameter("memPw").equals(authInfo.getUserPw())) {
			MemberDAO dao= new MemberDAO();
			dao.pwChange(userId,memPw);
			return 1;
		} else {
			request.setAttribute("pwFail1", "Wrong password");
			return 2;
		}
	}
}
