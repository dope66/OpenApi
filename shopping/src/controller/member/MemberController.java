package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet implements Servlet{
	
	private void doProcess(HttpServletRequest request ,
			HttpServletResponse response )throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command= RequestURI.substring(contextPath.length());
		if(command.equals("/memAgree.mem")) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("member/agree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memRegist.mem")) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memJoin.mem")) {
			MemeberJoinPage action = new MemeberJoinPage();
			action.memInsert(request);
			response.sendRedirect("main.sm");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

}