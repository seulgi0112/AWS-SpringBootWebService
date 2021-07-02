package com.seulgi.book.springboot.domain.posts;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.seulgi.book.springboot.web.dto.PostsSaveRequestDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private PostsRepository postRepository;

	@After(value = "")
	public void tearDown() throws Exception{
		postRepository.deleteAll();
	}
	
	@Test
	public void reg_Posts() throws Exception{
		//given
		String title = "title";
		String content = "content";
		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
					.title(title)
					.content(content)
					.author("author")
					.build();
	
		String url = "http://localhost:" + port +"/api/v1/posts";
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
		
		//then
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<Posts> all = postRepository.findAll();
		Assertions.assertThat(all.get(0).getTitle()).isEqualTo(title);
		Assertions.assertThat(all.get(0).getContent()).isEqualTo(content);
		
	}

}
