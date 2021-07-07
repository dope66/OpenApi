package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberEmailCkService {
	@Autowired
	MemberRepository memberRepository;
	
	public int emailCk(String email,String ckOk) {
		MemberDTO dto =new MemberDTO();
		dto.setMemEmail(email);
		memberRepository.updateCkOk(dto);
		return memberRepository.updateCkOk(dto);
	}
}
