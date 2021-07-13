package controller.employee;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.employee.EmployeeInfoService;

@Controller
@RequestMapping("empEdit")
public class EmployeeMyPageController {
@Autowired
EmployeeInfoService employeeInfoService;
	@RequestMapping("empMyPage")
	public String MyPage(HttpSession session, Model model) {
		return "employee/employeeMyPage";
		
	}
	
}
