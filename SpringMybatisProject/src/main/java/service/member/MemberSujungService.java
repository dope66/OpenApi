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

	public void memUpdate(HttpSession session, MemberCommand memberCommand, Errors errors) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		if (bCryptPasswordEncoder.matches(memberCommand.getMemPw(),
				authInfo.getUserPw())) {
			MemberDTO dto = new MemberDTO();
			dto.setDetailAdd(memberCommand.getDetailAdd());
			dto.setMemAccount(memberCommand.getMemAccount());
			dto.setMemAddress(memberCommand.getMemAddress());
			dto.setMemEmail(memberCommand.getMemEmail());
			dto.setMemEmailCk(memberCommand.getMemEmailCk());
			dto.setMemPhone(memberCommand.getMemPhone());
			dto.setPostNumber(memberCommand.getPostNumber());
			dto.setMemId(memId);
			memberRepository.memUpdate(dto);
		} else {
			errors.rejectValue("memPw", "notPw");
		}
	}

}
