package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberInfoService;
import service.member.MemberSujungService;

@Controller
@RequestMapping("edit")
public class MemberMyPageController {
	@Autowired
	MemberInfoService memberInfoService;
@Autowired
MemberSujungService memberSujungService;
	@RequestMapping("myPage")
	public String myPage(HttpSession session, Model model) {

		memberInfoService.memInfo(model, session);
		return "member/memMyPage";
	}

	@RequestMapping("memDetail")
	public String memDetail(HttpSession session, Model model) {
		memberInfoService.memInfo(model, session);
		return "member/memDetail";
	}

	@RequestMapping("memSujung")

	public String memSujung(HttpSession session, Model model) {
		memberInfoService.memInfo(model, session);
		return "member/memSujung";
	}
	
	@RequestMapping("memSujungOk")
	public String memSujungOk(
		@ModelAttribute MemberCommand memberCommand, HttpSession session, Model model) {
		
		memberInfoService.memInfo(model, session);
		return "member/memDetail";
	}
	

}
