package com.statemachine.service;

public class AdministrativeCase {

	private State s=State.S1;

	public State getS() {
		return s;
	}

	public void setS(State s) {
		this.s = s;
	}
}
