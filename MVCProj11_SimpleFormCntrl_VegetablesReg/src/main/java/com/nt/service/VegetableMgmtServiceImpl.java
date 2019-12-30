package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.VegetableBO;
import com.nt.dao.VegetableDAO;
import com.nt.dto.VegetableDTO;

public class VegetableMgmtServiceImpl implements VegetableMgmtService {

	private VegetableDAO dao;
	
	public VegetableMgmtServiceImpl(VegetableDAO dao) {
		super();
		this.dao = dao;
	}//vegetableMgmtServiceImpl(-)

	@Override
	public boolean addVegetableItem(VegetableDTO dto) {
		int flag = 0;
		VegetableBO bo = null;
		bo = new VegetableBO();
		BeanUtils.copyProperties(dto, bo);
		flag = dao.saveVegetableItem(bo);
		if(flag!=0)
			return true;
		else
			return false;
	}//addVegetableItem(-)

	@Override
	public List<VegetableDTO> getAllVegs() {
		List<VegetableBO> listBO = null;
		List<VegetableDTO> listDTO = new ArrayList<VegetableDTO>();
		listBO = dao.fetchAllVegs();
		if(!listBO.isEmpty()) {
			listBO.forEach(bo->{
			VegetableDTO dto = new VegetableDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
			});
		}//if
		return listDTO;
	}//getAllVegs()

	@Override
	public boolean updateVeg(VegetableDTO dto) {
		VegetableBO bo = new VegetableBO();
		BeanUtils.copyProperties(dto, bo);
		int flag =0;
		try{
			dao.updateVegById(bo);
			flag =1;
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			flag= 0;
		}
		finally{
			if(flag!=0)
				return true;
			else
				return false;
		}//finally
	}//updateVeg(-)

	@Override
	public boolean deleteVeg(int vId) {
		int flag =0;
		flag = dao.deleteVegById(vId);
		if(flag!=0)
			return true;
		else
			return false;
	}//deleteVeg(-)

	@Override
	public VegetableDTO getVeg(int vId) {
		VegetableBO bo = dao.getVegById(vId);
		VegetableDTO dto = new VegetableDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}//getVeg(-)

}//class
