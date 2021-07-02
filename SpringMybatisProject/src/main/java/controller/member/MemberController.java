package controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("register")
public class MemberController {
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}

@RequestMapping(value="memRegist",method = RequestMethod.POST)
public String memRegist(
		@RequestParam (value="agree",defaultValue = "false")
		Boolean agree) {
	if(!agree)
	{
		return "member/agree";
	}
	return "member/memberForm";
}
}
