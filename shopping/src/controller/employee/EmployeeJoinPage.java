package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeJoinPage {
	
	public void empInsert(HttpServletRequest request) {
		EmployeeDTO dto= new EmployeeDTO();
		dto.setEmployeeId(request.getParameter("employeeId")); ///
		dto.setEmpUserid(request.getParameter("empUserId")); ///
		dto.setEmpPw(request.getParameter("empPw"));
		dto.setEmpName(request.getParameter("empName"));
		dto.setHireDate(request.getParameter("hireDate"));
		dto.setPhNumber(request.getParameter("phNumber"));
		dto.setJobId(request.getParameter("jobId"));
		dto.setOfficeNumber(request.getParameter("officeNumber"));
		dto.setEmail(request.getParameter("email"));
		dto.setEmpAddress(request.getParameter("empAddress"));
		EmployeeDAO dao=new EmployeeDAO();
		dao.empInsert(dto);
	}
}
