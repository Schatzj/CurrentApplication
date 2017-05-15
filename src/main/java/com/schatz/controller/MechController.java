package com.schatz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MechController {
	
	@RequestMapping(value = {"MechPage"})
	public String home() {
		return "home/MechPage";
	}

}
