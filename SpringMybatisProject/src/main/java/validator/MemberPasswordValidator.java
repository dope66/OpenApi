package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberCommand;

public class MemberPasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	// 	object target으로 만든 이유는 모든데이터를 저장할수있는 자료형이고
	//	자료가뭔지 몰라 시벌 그럼 넌 object야 
	@Override
	public void validate(Object target, Errors errors) {

		MemberCommand regReq=(MemberCommand)target;
		ValidationUtils.rejectIfEmpty(errors, "oldPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPwCon", "required");
		if(!regReq.getMemPw().isEmpty()) {
			if(!regReq.isMemPwEqualsMemPwCon()) {
				errors.rejectValue("memPwCon","nomatch");
			}
		}
	}

	
	
}
