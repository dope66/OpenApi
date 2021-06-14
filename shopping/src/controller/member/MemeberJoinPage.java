package controller.member;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemeberJoinPage {
	public void memInsert(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		MemberDTO dto= new MemberDTO();
		dto.setDetailAdd(request.getParameter("detailadd"));
		dto.setMemAccount(request.getParameter("memAccount"));
		dto.setMemAddress(request.getParameter("memAddress"));
		dto.setMemEmail(request.getParameter("memEmail"));
		dto.setMemEmailCk(request.getParameter("memEmailCk"));
		dto.setMemGender(request.getParameter("memGender"));
		dto.setMemId(request.getParameter("memId"));
		dto.setMemName(request.getParameter("memName"));
		dto.setMemPhone(request.getParameter("memPhone"));
		dto.setPostNumber(request.getParameter("postNumber"));
		dto.setMemPw(request.getParameter("memPw"));
		String birth=request.getParameter("memBirth");
		SimpleDateFormat sf= new SimpleDateFormat("yyyy-mm-dd");
		Date memBirth=null;
		try {
			 memBirth=sf.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setMemBirth(memBirth);
		MemberDAO dao= new MemberDAO();
		dao.memInsert(dto);
		
	}
}
