package com.seulgi.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seulgi.book.springboot.web.dto.HelloResponseDto;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, 
			@RequestParam("amount") int amount) {
		return new HelloResponseDto(name, amount);
	}
}
