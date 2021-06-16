package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DTO.AuthInfo;

public class EmployeeConfirmPage {

	public void empConfirm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		AuthInfo authInfo= (AuthInfo) session.getAttribute("authInfo");
		
		
	}
}
