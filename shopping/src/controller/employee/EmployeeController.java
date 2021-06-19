package controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.member.MemberDetailPage;
import controller.member.MemberPwChange;

public class EmployeeController extends HttpServlet implements Servlet {
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if (command.equals("/empList.em")) {
			EmployeeListPage action = new EmployeeListPage();
			action.empList(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeList.jsp");
			dispatcher.forward(request, response);
			// 리스트 목록
		} else if (command.equals("/empRegest.em")) {
			EmployeeNumPage action = new EmployeeNumPage();
			action.getNum(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeForm.jsp");
			dispatcher.forward(request, response);
			// 직원 등록 페이지
		} else if (command.equals("/empJoin.em")) {
			EmployeeJoinPage action = new EmployeeJoinPage();
			action.empInsert(request);
			response.sendRedirect("empList.em");
			// 직원 한줄 추가
		}

		else if (command.equals("/empDetail.em")) {
			EmployeeDetailPage action = new EmployeeDetailPage();
			action.empDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empDetail.jsp");
			dispatcher.forward(request, response);

		}
		
		else if (command.equals("/empModify.em")) {

			EmployeeInfoPage action = new EmployeeInfoPage();
			action.empInfo(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeModify.jsp");
			dispatcher.forward(request, response);
			//직원리스트에서의 수정 
		} else if (command.equals("/empModifyOk.em")) {
			EmployeeModifyPage action = new EmployeeModifyPage();
			action.empModify(request);
			response.sendRedirect("empList.em");
		} else if (command.equals("/empDelete.em")) {
			EmployeeDeletePage action = new EmployeeDeletePage();
			action.empDelete(request);
			response.sendRedirect("empList.em");
		}
		// 여기서부터
		else if (command.equals("/empSujung.em")) {
			EmployeeDetailPage action = new EmployeeDetailPage();
			action.empDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empSujung.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empSujungOk.em")) {
			EmployeeUpdatePage action =new EmployeeUpdatePage();
			int i=action.employeeUpdate(request);
			
			if(i==1) {
				response.sendRedirect("empDetail.em");
			}
			else {
				response.sendRedirect("empSujung.em");
			}
		}

		else if (command.equals("/empMyPage.em")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeMyPage.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/empInfo.em")) {
			EmployeeInfoPage action = new EmployeeInfoPage();
			action.empInfo(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeInfo.jsp");
			dispatcher.forward(request, response);
			// 직원리스트에서 직원을 보는게 info 임
		}

		else if (command.equals("/PwChange.em")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/PwChange.jsp");
			dispatcher.forward(request, response);

		}

		else if (command.equals("/PwChangeOk.em")) {
			EmployeeConfirmPage action = new EmployeeConfirmPage();
			String path = action.empConfirm(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		else if(command.equals("/ChangeEmpPw.em")) {
	EmployeePwChange action = new EmployeePwChange();
			
			int i=action.empPwChange(request);
			if(i==1)
			{
				response.sendRedirect("main.sm");
			}else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("employee/PwChange.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}