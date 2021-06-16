package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberDetailPage {
	public void memDetail(HttpServletRequest request) {
		HttpSession session =request.getSession();
		AuthInfo authInfo=(AuthInfo)session.getAttribute("authInfo");
		String memId=authInfo.getUserId(); // session userId get 
		MemberDAO dao= new MemberDAO();
		MemberDTO dto=dao.memDetail(memId);
		request.setAttribute("dto", dto);
	}
}
