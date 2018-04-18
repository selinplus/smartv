package com.bigearblessed.smartv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WechatController {
	@GetMapping(value = "/login")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/test")
	public String test() {
		return "test";
	}
}
