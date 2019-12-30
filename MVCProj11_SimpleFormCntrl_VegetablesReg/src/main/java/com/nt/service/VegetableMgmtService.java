package com.nt.service;

import java.util.List;

import com.nt.dto.VegetableDTO;

public interface VegetableMgmtService {
	
	public boolean addVegetableItem(VegetableDTO dto);
	
	public List<VegetableDTO> getAllVegs();
	
	public boolean updateVeg(VegetableDTO dto);
	
	public boolean deleteVeg(int vId);
	
	public VegetableDTO getVeg(int vId);

}
