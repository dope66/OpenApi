package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberInfoService;
import service.member.MemberOutService;
import service.member.MemberPwChangeService;
import service.member.MemberPwUpdateService;
import service.member.MemberSujungService;
import validator.MemberPasswordValidator;

@Controller
@RequestMapping("edit")
public class MemberMyPageController {
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberSujungService memberSujungService;
	@Autowired
	MemberPwChangeService memberPwChangeService;
	@Autowired
	MemberPwUpdateService memberPwUpdateService;
@Autowired
MemberOutService memberOutService; 

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
	public String memSujung(HttpSession session,Model model,
			@ModelAttribute MemberCommand memberCommand) {
		memberInfoService.memInfo(model, session);
		return "member/memSujung";
	}

	@RequestMapping(value="memSujungOk",
			method = RequestMethod.POST)
	//에러는 항상 커맨드 객체 뒤에다가 둬야된다 
	public String memUpdate(MemberCommand memberCommand,
			Errors errors, HttpSession session) {
		memberSujungService.memUpdate(session,memberCommand,errors);
		if(errors.hasErrors()) {
			return "member/memSujung";
		}
		return "redirect:memDetail";
	}
	@RequestMapping("memPwChange")
	public String memPwChange() {
		return "member/pwChange";
	}
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(
			@RequestParam(value = "memPw") String memPw,
			HttpSession session,Model model,
			@ModelAttribute MemberCommand memberCommand) {
		String path = memberPwChangeService.memPw(memPw,session,model);
		return path ;
	}
	@RequestMapping("changePw")
	public String changePw(MemberCommand memberCommand,
			Errors errors,HttpSession session) {
		new MemberPasswordValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/pwChangeOk";
		}
		memberPwUpdateService.memPwUpdate(memberCommand,errors,
				session);
		if(errors.hasErrors()) {
			return "member/pwChangeOk";
		}
		return "redirect:/";
	}
	
	@RequestMapping("memOut")
	public String memOut(){
		return "member/outPw";
	}
	@RequestMapping("memOutOk")
	public String memOutOk(
			@RequestParam(value="memPw") String memPw,
			HttpSession session, Model model){
		String path = memberOutService.memDelete(memPw, session, model);
		return path;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
