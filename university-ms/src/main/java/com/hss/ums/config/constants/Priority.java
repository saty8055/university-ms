package com.hss.ums.config.constants;

public enum Priority {

	HIGH(1), MEDIUM(0), LOW(-1);
	
	private int value;
	
	private Priority(Integer value) {
		this.value = value;
	}
	
	public int get() {
		return this.value;
	}
	
}
