package com.statemachine.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.statemachine.service.Event;
import com.statemachine.service.State;
import com.statemachine.service.AdministrativeCaseService;

@Configuration
@EnableWebMvc
@ComponentScan("com.statemachine")
public class RootContextConfiguration {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public StateMachine<State, Event> getStateMachine() throws Exception {

		Builder<State, Event> builder = StateMachineBuilder.builder();
		builder.configureConfiguration().withConfiguration().autoStartup(true);
		builder.configureStates().withStates().states(new HashSet<State>(Arrays.asList(State.values())));
		builder.configureStates().withStates().initial(State.S1);
		builder.configureTransitions().withInternal().source(State.S1).event(Event.E11).guard(g->true)
				.action(new Action<State, Event>() {

					@Override
					public void execute(StateContext<State, Event> context) {
						Map<Object, Object> map = context.getExtendedState().getVariables();
						getAdministrtiveCaseService().S1ToS1((Long) map.get("value"));
					}
				});
		builder.configureTransitions().withExternal().source(State.S1).target(State.S2).event(Event.E12)
				.action(new Action<State, Event>() {

					@Override
					public void execute(StateContext<State, Event> context) {
						Map<Object, Object> map = context.getExtendedState().getVariables();
						getAdministrtiveCaseService().S1ToS2((Long) map.get("value"));
					}
				});
		builder.configureTransitions().withInternal().source(State.S2).event(Event.E22)
		.action(new Action<State, Event>() {

			@Override
			public void execute(StateContext<State, Event> context) {
				Map<Object, Object> map = context.getExtendedState().getVariables();
				getAdministrtiveCaseService().S2ToS2((Long) map.get("value"));
			}
		});
		builder.configureTransitions().withExternal().source(State.S2).target(State.S3).event(Event.E23)
		.action(new Action<State, Event>() {

			@Override
			public void execute(StateContext<State, Event> context) {
				Map<Object, Object> map = context.getExtendedState().getVariables();
				getAdministrtiveCaseService().S2ToS3((Long) map.get("value"));
			}
		});
		builder.configureTransitions().withExternal().source(State.S3).target(State.S1).event(Event.E31)
		.action(new Action<State, Event>() {

			@Override
			public void execute(StateContext<State, Event> context) {
				Map<Object, Object> map = context.getExtendedState().getVariables();
				getAdministrtiveCaseService().S3ToS1((Long) map.get("value"));
			}
		});
		return builder.build();
	}

	@Bean
	public AdministrativeCaseService getAdministrtiveCaseService() {
		return new AdministrativeCaseService();
	}
}
