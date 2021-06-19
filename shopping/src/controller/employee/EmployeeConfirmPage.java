package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DTO.AuthInfo;

public class EmployeeConfirmPage {

	public String empConfirm(HttpServletRequest request) {
		String path=null;
		HttpSession session = request.getSession();
		AuthInfo authInfo= (AuthInfo) session.getAttribute("authInfo");
		if(request.getParameter("empPw").equals(authInfo.getUserPw())) {
			path="employee/PwChangeOk.jsp";
			
		}else {
			request.setAttribute("pwFail1","Wrong password");
			path="employee/PwChange.jsp";
		}
		return path;
		
		
	}
}
