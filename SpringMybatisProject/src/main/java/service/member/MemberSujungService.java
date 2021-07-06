package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.MemberCommand;
import model.AuthInfoDTO;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberSujungService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void memSujungOk(MemberCommand memberCommand, Errors errors, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		String memPw = authInfo.getUserPw();
		if (bCryptPasswordEncoder.matches(memPw, authInfo.getUserPw())) {
			session.setAttribute("authInfo", authInfo);
			MemberDTO dto = new MemberDTO();
			dto.setDetailAdd(memberCommand.getDetailAdd());
			dto.setMemAccount(memberCommand.getMemAccount());
			dto.setMemAddress(memberCommand.getMemAddress());
			dto.setMemEmail(memberCommand.getMemEmail());
			dto.setMemEmailCk(memberCommand.getMemEmailCk());
			dto.setMemPhone(memberCommand.getMemPhone());
			dto.setPostNumber(memberCommand.getPostNumber());
			dto.setMemId(memberCommand.getMemId());
			dto.setMemPw(memberCommand.getMemPw());
			memberRepository.memUpdate(dto);
		} else {
			errors.rejectValue("memPw", "notPw");
		}
	}

}
