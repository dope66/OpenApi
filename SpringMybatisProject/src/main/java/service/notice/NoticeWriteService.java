package service.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.NoticeCommand;
import model.AuthInfoDTO;
import model.NoticeDTO;
import repository.NoticeRepository;

public class NoticeWriteService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeWrite(HttpSession session , NoticeCommand noticeCommand) {
		AuthInfoDTO authInfo= (AuthInfoDTO)session.getAttribute("authInfo"); // 로그인 정보를 가지고오기 위함 
		String employeeId= authInfo.getGrade(); //직원의 아이디를 가지고와야되서 그레이드
		NoticeDTO dto= new NoticeDTO();
		dto.setNoticeCon(noticeCommand.getNoticeCon());
		dto.setNoticeKind(noticeCommand.getNoticeKind());
		dto.setNoticeSub(noticeCommand.getNoticeSub());
		dto.setEmployeeId(employeeId);
		noticeRepository.noticeWrite(dto);
		
	}
}
