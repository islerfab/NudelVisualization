package com.example.nudelvisualization.client;

public class Item implements FilterItem {
	
	private boolean active = false;
	private String name;
	private String ID;
	
	public Item(String ID, String name){
		this.ID = ID;
		this.name = name;
	}
	
	@Override
	public boolean getActive() {
		return this.active;
	}
	
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	

}