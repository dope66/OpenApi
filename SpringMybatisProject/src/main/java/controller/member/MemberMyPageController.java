package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.MemberCommand;
import service.member.MemberInfoService;
import service.member.MemberSujungService;
import validator.MemberCommandValidator;

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
		MemberCommand memberCommand,HttpSession session, Model model,Errors errors) {
		new MemberCommandValidator().validate(memberCommand, errors);
		memberInfoService.memInfo(model, session);
		return "member/memDetail";
	}
	

}
