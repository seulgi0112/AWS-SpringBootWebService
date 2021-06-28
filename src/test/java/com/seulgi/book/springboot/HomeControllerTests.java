package com.seulgi.book.springboot;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.seulgi.book.springboot.web.HomeController;

@WebMvcTest(HomeController.class)
public class HomeControllerTests {
	@Autowired
	private MockMvc mvc;	//MockMvc : 웹 API 테스트할때 사용
	
	@Test
	public void helloTest() throws Exception{
		//given
		String hello = "hello";
		//when
		mvc.perform(MockMvcRequestBuilders.get("/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(hello));
	}
	
	@Test
	public void return_helloDto() throws Exception{
		String name = "hello";
		int amount = 1000;
		
		mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
				.param("name", name)
				.param("amount", String.valueOf(amount)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(name)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(amount)));
	}
}
