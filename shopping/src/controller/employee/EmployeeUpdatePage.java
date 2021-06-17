package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;

public class EmployeeUpdatePage {
	public int employeeUpdate(HttpServletRequest request) {
		HttpSession session =request.getSession();
		AuthInfo authInfo=(AuthInfo) session.getAttribute("authInfo");
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmail(request.getParameter("email"));
		dto.setEmpAddress(request.getParameter("empAddress"));
		dto.setEmployeeId(request.getParameter("employeeId"));
		dto.setEmpName(request.getParameter("empName"));
		dto.setEmpUserid(request.getParameter("empUserid"));
		dto.setJobId(request.getParameter("jobId"));
		dto.setOfficeNumber(request.getParameter("officeNumber"));
		dto.setPhNumber(request.getParameter("phNumber"));
		dto.setHireDate(request.getParameter("hireDate"));
		
		if(request.getParameter("empPw").equals(authInfo.getUserPw())) {
			EmployeeDAO dao=new EmployeeDAO();
			dao.empUpdate(dto);
			session.removeAttribute("pwFail");
			return 1;
		}else
		{
			session.setAttribute("pwFail","Wrong password");
			return 2;
		}
		
	}
}
