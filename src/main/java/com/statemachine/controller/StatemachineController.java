package com.statemachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.statemachine.service.Event;
import com.statemachine.service.AdministrativeCaseService;

@Controller
@RequestMapping("/")
public class StatemachineController {

	@Autowired
	private AdministrativeCaseService administrativeCaseService;
	
	@GetMapping()
	public String goHome(@RequestParam("id") Long id, @RequestParam("event") Event e, Model model) {
		
		administrativeCaseService.triggerEvent(id, e);
		model.addAttribute("cases", administrativeCaseService.getAll());
		model.addAttribute("case1", administrativeCaseService.getPossibleEvents(1l));
		model.addAttribute("case2", administrativeCaseService.getPossibleEvents(2l));
		model.addAttribute("case3", administrativeCaseService.getPossibleEvents(3l));
		
		return "index";
	}
}
