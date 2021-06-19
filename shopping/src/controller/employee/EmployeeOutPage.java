package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;

public class EmployeeOutPage {

	public int empOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if (request.getParameter("empPw").equals(authInfo.getUserPw())) {
			EmployeeDAO dao = new EmployeeDAO();
			dao.empDel(authInfo.getUserId());
			session.invalidate();//remove�� �Ӽ��� ������ �̰� ���δ� ����
			return 1;
		} else {
			session.setAttribute("pwFail", "Wrong password");
			return 2;
		}
	}
}
