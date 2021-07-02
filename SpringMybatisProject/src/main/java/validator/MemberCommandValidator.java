package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import command.MemberCommand;

public class MemberCommandValidator {
	public boolean supports(Class<?> clazz) {
		return false;
	}
	public void validate(Object target, Errors errors)
	{
		MemberCommand memberCommand =(MemberCommand)target;
		if(!memberCommand.isMemPwEqualsMemPwCon()) {
			errors.rejectValue("memPwCon", "nomatch");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memId", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memAddress", "required");
		ValidationUtils.rejectIfEmpty(errors, "memName", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPhone", "required");
		ValidationUtils.rejectIfEmpty(errors, "memBirth", "required");
		ValidationUtils.rejectIfEmpty(errors, "memGender", "required");
		ValidationUtils.rejectIfEmpty(errors, "memEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "memEmailCk", "required");
		
		
	}
	
}
