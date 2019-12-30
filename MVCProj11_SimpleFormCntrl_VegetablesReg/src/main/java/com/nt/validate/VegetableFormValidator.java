package com.nt.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.VegetableCommand;

public class VegetableFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz==VegetableCommand.class;
	}//supports(-)

	@Override
	public void validate(Object command, Errors errors) {
		VegetableCommand cmd = null;
		cmd = (VegetableCommand)command;
		
		if(!cmd.isFormValFlag()) {
			if(cmd.getVname()==null || cmd.getVname().isEmpty())
				errors.rejectValue("vname", "vegName.required");
			else if(cmd.getVname().length()<3)
				errors.rejectValue("vname", "vegName.length");
			if(cmd.getVitamins()==null || cmd.getVitamins().isEmpty())
				errors.rejectValue("vitamins","vegVitamin.required");
			if(cmd.getVprice()==null || cmd.getVprice()<=0)
				errors.rejectValue("vprice", "vegPrice.negative");
		}//if
	}//validate(-,-)

}//class
