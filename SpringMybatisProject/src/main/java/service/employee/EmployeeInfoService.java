package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void empInfo(String empId,   Model model) {
		
				
		EmployeeDTO dto=employeeRepository.empInfo(empId);
		model.addAttribute("emp",dto);
	

	}
} 
