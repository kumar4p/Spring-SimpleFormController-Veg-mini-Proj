package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import com.nt.command.VegetableCommand;
import com.nt.service.VegetableMgmtService;

public class DeleteVegController extends AbstractController {

	private VegetableMgmtService service;
	
	public DeleteVegController(VegetableMgmtService service) {
		super();
		this.service = service;
	}//DeleteVegController(-)

	@Override
	public  ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		boolean flag = false;
		int vId =0;
		vId = Integer.parseInt(request.getParameter("vId"));
		flag = service.deleteVeg(vId);
		//return new  ModelAndView(new RedirectView("/MVCProj11_SimpleFormCntrl_VegetablesReg/viewAllVeg.htm?flag="+flag));
		return new  ModelAndView("redirect:/viewAllVeg.htm?flag="+flag);
	}//handleRequestInternal(-,-)

}//class
