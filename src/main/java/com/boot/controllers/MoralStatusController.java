package com.boot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoralStatusController {

	@RequestMapping(path = "/test")
	public boolean executeTest() {
		return true;
	}

}
