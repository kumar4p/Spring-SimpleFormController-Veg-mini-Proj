package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.VegetableCommand;
import com.nt.dto.VegetableDTO;
import com.nt.service.VegetableMgmtService;

public class ViewAllVegetableController extends AbstractCommandController {

	
	private VegetableMgmtService vegService;

	public ViewAllVegetableController(VegetableMgmtService vegService) {
		super();
		this.vegService = vegService;
	}
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
		ModelAndView model = new ModelAndView();
		if(flag) {
			model.addObject("delMsg", "Record Deleted Successfully");
		}
		model.setViewName("viewAllVegs");
		List<VegetableDTO> listDTO = vegService.getAllVegs();
		List<VegetableCommand> listCommand = new ArrayList<VegetableCommand>();
		if(listDTO!=null) {
			listDTO.forEach(dto->{
				VegetableCommand c = new VegetableCommand();
				BeanUtils.copyProperties(dto, c);
				listCommand.add(c);
			});
			model.addObject("listCmd", listCommand);
		}
		model.addObject("rMsg", "no Vegetable records to show");
			//model.put("listCmd",listCommand);
			return model;
	}//hable(-,-,-,-)

}//class
