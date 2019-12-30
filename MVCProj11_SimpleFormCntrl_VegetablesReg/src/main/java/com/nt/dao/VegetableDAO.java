package com.nt.dao;

import java.util.List;

import com.nt.bo.VegetableBO;

public interface VegetableDAO {
	
	public int saveVegetableItem(VegetableBO bo);
	
	public List<VegetableBO> fetchAllVegs();
	
	public int deleteVegById(int vId);
	
	public VegetableBO getVegById(int vId);
	
	public void updateVegById(VegetableBO bo);
}
