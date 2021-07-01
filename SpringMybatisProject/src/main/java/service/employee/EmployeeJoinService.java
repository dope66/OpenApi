package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeJoinService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder; 
	public void empInsert(EmployeeCommand employeeCommand) {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmail(employeeCommand.getEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPw(bcryptPasswordEncoder.encode(
				employeeCommand.getEmpPw()));
		dto.setEmpUserId(employeeCommand.getEmpUserId());
		dto.setJobId(employeeCommand.getJobId());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setPhNumber(employeeCommand.getPhNumber());
		dto.setHireDate(employeeCommand.getHireDate());
		System.out.println(dto.getEmail());
		System.out.println(dto.getEmpAddress());
		System.out.println(dto.getEmployeeId());
		System.out.println(dto.getEmpName());
		System.out.println(dto.getEmpPw());
		System.out.println(dto.getEmpUserId());
		System.out.println(dto.getJobId());
		System.out.println(dto.getOfficeNumber());
		System.out.println(dto.getPhNumber());
		System.out.println(dto.getHireDate());
		employeeRepository.empInsert(dto);
	}
}
