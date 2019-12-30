package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.VegetableBO;

public class VegetableDAOImpl implements VegetableDAO {

	private static final String ADD_VEGETABLE="INSERT INTO VEGETABLE_REG (VID, VNAME, STATUS, VITAMINS, VPRICE) VALUES (VEGID_SEQ.NEXTVAL,?,?,?,?)";
	private static final String FETC_ALL_VEGS = "SELECT VID,VNAME,STATUS,VITAMINS,VPRICE FROM VEGETABLE_REG";
	private static final String UPDATE_VEG ="UPDATE VEGETABLE_REG SET VNAME = ?, STATUS = ?, VITAMINS = ?, VPRICE = ? WHERE VID = ?";
	private static final String DELETE_VEG ="DELETE FROM VEGETABLE_REG WHERE VID=?";
	private static final String GET_VEG_ID ="SELECT VID,VNAME,STATUS,VITAMINS,VPRICE FROM VEGETABLE_REG WHERE VID=?";
	
	private JdbcTemplate jt;
	
	public VegetableDAOImpl(JdbcTemplate jt) {
		super();
		this.jt = jt;
	}//vegetanleDAOImpl(-)
	@Override
	
	public int saveVegetableItem(VegetableBO bo) {
		return jt.update(ADD_VEGETABLE,bo.getVname(),bo.isStatus(),bo.getVitamins(),bo.getVprice());
	}//saveVegetableItem(-)
	
	@Override
	public List<VegetableBO> fetchAllVegs() {
		return (List<VegetableBO>) jt.query(FETC_ALL_VEGS, new RowMapperResultSetExtractor(
											new BeanPropertyRowMapper(VegetableBO.class)
											)
				);
	}//fetchAllVegs()
	
	@Override
	public int deleteVegById(int vId) {
		return jt.update(DELETE_VEG,vId);
	}//deleteVegById(-)
	
	@Override
	public void updateVegById(VegetableBO bo) {
		 jt.update(UPDATE_VEG, bo.getVname(),bo.isStatus(),bo.getVitamins(),bo.getVprice(),bo.getVid());
	}//updateVegById(-)
	
	@Override
	public VegetableBO getVegById(int vId) {
		return jt.queryForObject(GET_VEG_ID, new Object[] {vId}, new RowMapper<VegetableBO>() {
			@Override
			public VegetableBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VegetableBO bo = new VegetableBO();
				bo.setVid(rs.getInt("vId"));
				bo.setVname(rs.getString("vName"));
				bo.setStatus(rs.getBoolean("status"));
				bo.setVitamins(rs.getString("vitamins"));
				bo.setVprice(rs.getFloat("vprice"));
				return bo;
			}
		});
	}//getVegById(-)
}//class
