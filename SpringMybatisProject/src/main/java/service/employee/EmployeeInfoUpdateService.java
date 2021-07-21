package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.EmployeeCommand;
import model.AuthInfoDTO;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
public  void empUpdate(EmployeeCommand employeeCommand, Errors errors,HttpSession session) {
	
	
	EmployeeDTO dto= new EmployeeDTO();
	dto.setEmail(employeeCommand.getEmail());
	dto.setEmpAddress(employeeCommand.getEmpAddress());
	dto.setEmpName(employeeCommand.getEmpName());
	dto.setOfficeNumber(employeeCommand.getOfficeNumber());
	dto.setPhNumber(employeeCommand.getPhNumber());
	AuthInfoDTO authInfo =(AuthInfoDTO)session.getAttribute("authInfo");
	dto.setEmpUserId(authInfo.getUserId());
	EmployeeDTO d= employeeRepository.empDetail(employeeCommand.getEmpUserId());
	
	if(!bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), d.getEmpPw())) {
		errors.rejectValue("empPw", "notPw");
		return;
	}
	
	employeeRepository.empModify(dto);
}
}
