package service.employee;

import org.springframework.beans.factory.annotation.Autowired;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empUpdate(EmployeeCommand employeeCommand){
		EmployeeDTO dto= new EmployeeDTO();
		dto.setEmail(employeeCommand.getEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setJobId(employeeCommand.getJobId());
		dto.setPhNumber(employeeCommand.getPhNumber());
		employeeRepository.empUpdate(dto);
		
		
	} 
}
