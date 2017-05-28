package com.gabriel.droidr.core;

public class Intent {

	protected Activity from;
	protected Class<?> to;
	
	public Intent(Activity from, Class<?> to) {
		this.from = from;
		this.to = to;
	}
	
}
