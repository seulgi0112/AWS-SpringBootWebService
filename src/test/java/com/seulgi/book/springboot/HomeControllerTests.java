package com.seulgi.book.springboot;

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
}
