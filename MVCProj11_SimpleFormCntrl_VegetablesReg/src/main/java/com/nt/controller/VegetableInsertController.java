package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.VegetableCommand;
import com.nt.dto.VegetableDTO;
import com.nt.service.VegetableMgmtService;

public class VegetableInsertController extends SimpleFormController {
	
	private VegetableMgmtService service;
	
	public VegetableInsertController(VegetableMgmtService service) {
		super();
		this.service = service;
	}//vegetableInsertController(-)

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		VegetableCommand cmd = null;
		boolean insFlag = false;
		VegetableDTO dto = null;
		cmd = (VegetableCommand)command;
		if(cmd.getVprice()<=40) {
			errors.rejectValue("vPrice", "veg.price");
			return showForm(request, response, errors);
		}//if
		else {
			if(cmd.getVid()==0) {
				dto = new VegetableDTO();
				BeanUtils.copyProperties(cmd, dto);
				insFlag = service.addVegetableItem(dto);
				return new ModelAndView("result", "insFlag",insFlag);
			}//if
			else {
				dto = new VegetableDTO();
				BeanUtils.copyProperties(cmd, dto);
				boolean updFlag = service.updateVeg(dto);
				return new ModelAndView("result", "updFlag",updFlag);
			}//else
		}//else
	}//onSubmit(-,-,-,-)
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("dbl_error");
	}//handleInvalidSubmit(-,-)
	
}//class
