package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class VegetableDTO implements Serializable {
	private int vid;
	private String vname;
	private boolean status;
	private String vitamins;
	private float vprice;
}//class
