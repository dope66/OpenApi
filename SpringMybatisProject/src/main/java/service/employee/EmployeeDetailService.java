package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeDetailService {
 @Autowired
 EmployeeRepository employeeRepository;
	public void empInfo(HttpSession session,Model model) {
		//db로 부터 값을 넘겨받기위해서 모델을 쓴다 
	AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
	String empId=authInfo.getUserId();
	
	EmployeeDTO dto=employeeRepository.empDetail(empId);
	model.addAttribute("employeeCommand",dto);
	}
}
