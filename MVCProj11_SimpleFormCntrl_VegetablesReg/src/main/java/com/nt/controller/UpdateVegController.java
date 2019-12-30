package com.nt.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.command.VegetableCommand;
import com.nt.dto.VegetableDTO;
import com.nt.service.VegetableMgmtService;

public class UpdateVegController extends AbstractCommandController {

	private VegetableMgmtService service;
	
	public UpdateVegController(VegetableMgmtService service) {
		super();
		this.service = service;
	}//updateVegController(-)

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		return new ModelAndView("veg_reg_form","cmd",command);
	}//handle(-,-,-,-)
	

	@Override
	public void onBind(HttpServletRequest request, Object command) throws Exception {
		VegetableCommand cmd = (VegetableCommand) command;
		String parameter = request.getParameter("vId");
		int vId = Integer.parseInt(parameter);
		VegetableDTO dto = service.getVeg(vId);
		BeanUtils.copyProperties(dto, cmd);
	}//onBind(-,-)

}//classs
