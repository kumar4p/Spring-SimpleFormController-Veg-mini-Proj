package com.nt.command;

import lombok.Data;

@Data
public class VegetableCommand {
	private int vid;
	private String vname;
	private boolean status;
	private String vitamins;
	private Float vprice;
	private boolean formValFlag;

}//class
