//package com.statemachine.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.statemachine.config.EnableStateMachine;
//import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
//import org.springframework.web.context.annotation.SessionScope;
//
//import com.statemachine.service.Event;
//import com.statemachine.service.State;
//
//@Configuration
//@EnableStateMachine
//@SessionScope
//public class StateMachineConfig extends StateMachineConfigurerAdapter<State, Event>{
//
//	@Override
//	public void configure(StateMachineStateConfigurer<State, Event> states) throws Exception {
//		
//		states.withStates().initial(State.S1);
//	}
//	
//	@Override
//	public void configure(StateMachineTransitionConfigurer<State, Event> transitions) throws Exception {
//	
//		transitions.withExternal().source(State.S1).target(State.S2);
//	}
//}