package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberInfoService {
	@Autowired
	MemberRepository memberRepository; 
	
	public void memInfo(Model model ,HttpSession session) {
		//로그인 했을때 session에 저장 
		AuthInfoDTO authInfo=(AuthInfoDTO) session.getAttribute("authInfo");
		String memId=authInfo.getUserId();
		MemberDTO dto= memberRepository.memInfo(memId);
		model.addAttribute("memberCommand",dto);
	}
}
