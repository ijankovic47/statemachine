package com.statemachine.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.transition.Transition;

public class AdministrativeCaseService {

	@Autowired
	private StateMachine<State, Event> stateMachine;
	@Autowired
	private AdministrativeCaseDao adminDao;

	public void triggerEvent(Long caseId, Event e) {

		AdministrativeCase ac = adminDao.getCase(caseId);
		setMachineIntoState(ac.getS());
		stateMachine.getExtendedState().getVariables().put("value", caseId);
		stateMachine.sendEvent(e);

	}

	private void setMachineIntoState(State s) {

		stateMachine.getStateMachineAccessor().doWithAllRegions(access -> {
			access.resetStateMachine(new DefaultStateMachineContext<>(s, null, null, null, null));
		});
		System.out.println("Masinu postavljamo u state: " + stateMachine.getState().getId());
	}

	public void S1ToS1(Long caseId) {

		System.out.println("S1 to S1 za postupak id " + caseId);
	}

	public void S1ToS2(Long caseId) {

		adminDao.getCase(caseId).setS(State.S2);
		System.out.println("S1 to S2 za postupak id " + caseId);
	}

	public void S2ToS2(Long caseId) {

		System.out.println("S2 to S2 za postupak id " + caseId);
	}

	public void S2ToS3(Long caseId) {
		adminDao.getCase(caseId).setS(State.S3);
		System.out.println("S2 to S3 za postupak id " + caseId);
	}

	public void S3ToS1(Long caseId) {
		adminDao.getCase(caseId).setS(State.S1);
		System.out.println("S3 to S1 za postupak id " + caseId);
	}
	
	public List<Event> getPossibleEvents(Long caseId){
		
		AdministrativeCase ac=adminDao.getCase(caseId);
		List<Transition<State, Event>> allTransitions=(List<Transition<State, Event>>) stateMachine.getTransitions();
		List<Transition<State, Event>> transitionsFromCurrentState=new ArrayList<>();
		List<Event> events=new ArrayList<>();
		for(Transition<State, Event> t:allTransitions) {
			if(t.getSource().getId().equals(ac.getS())) {
				transitionsFromCurrentState.add(t);
				events.add(t.getTrigger().getEvent());
				
			}
		}
		
		return events;
	}
	
	public List<AdministrativeCase> getAll(){
		return adminDao.getAll();
	}
}
