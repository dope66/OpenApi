package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;

public class EmpPwChangePage {
	 public int empPwChange(HttpServletRequest request)
	 {
			HttpSession session = request.getSession();
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			String userId=authInfo.getUserId();
			String empPw=request.getParameter("newPw");
			
			if (request.getParameter("empPw").equals(authInfo.getUserPw())) {
				EmployeeDAO dao= new EmployeeDAO();
				dao.empPwChange(userId,empPw);
				return 1;
			} else {
				request.setAttribute("pwFail1", "Wrong password");
				return 2;
			}
	 }
}
