package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDeleteService;
import service.member.MemberListService;
import service.member.MemberUpdateService;
@Controller
@RequestMapping("member")
public class MemberInfoController {
	@Autowired
	MemberListService memberListService;
	@RequestMapping("memList")
 public String memList(
		 @RequestParam(value="page",defaultValue = "1")//페이지를 날리지않아도 1값을 갖게된다.
		 Integer page,
		 Model model) {
		memberListService.memList(model,null,page);
	 return "member/memberList";
	 
 }
	@Autowired
	MemberUpdateService memberUpdateService; 
	@RequestMapping(value="memModifyOk",method = RequestMethod.POST)
	public String memUpdate(MemberCommand memberCommand) {
		memberUpdateService.memUpdate(memberCommand);
		return "redirect:memInfo/"+memberCommand.getMemId();
	}
	@RequestMapping("memInfo/{memId}")
	public String memInfo(
			@PathVariable(value="memId")String memId,
			Model model) {
		memberListService.memList(model,memId,1);
		return "member/memberInfo";
		
	}
	@Autowired
	MemberDeleteService memberDeleteService;
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value="memId")String memId) {
		memberDeleteService.memDel(memId);
		
		return "redirect:memList";
	}
	@RequestMapping("memMod/{memId}")
	public String memMod(@PathVariable(value="memId")String memId,
			Model model) {
		memberListService.memList(model,memId,1);
		return "member/memberModify";

	}
	@RequestMapping("member/pwChange")
	public String memPwChange() {
		return null;
		
	}
	
}
