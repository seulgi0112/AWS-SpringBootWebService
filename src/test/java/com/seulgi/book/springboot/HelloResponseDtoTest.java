package com.seulgi.book.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seulgi.book.springboot.web.dto.HelloResponseDto;

public class HelloResponseDtoTest {

	@Test
	public void lombokTest() {
		//given
		String name = "test";
		int amount = 1000;
		
		//when
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		//then
		Assertions.assertThat(dto.getName()).isEqualTo(name);
		Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
	}
}
