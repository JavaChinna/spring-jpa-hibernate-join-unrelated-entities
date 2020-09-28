package com.javachinna.demo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javachinna.model.PostInfo;
import com.javachinna.model.PostWithAuthor;
import com.javachinna.model.PostWithAuthorDTO;
import com.javachinna.repo.PostInfoRepository;
import com.javachinna.repo.PostRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostInfoRepository postInfoDAO;

	@Test
	public void getPostWithAuthorJpaTest() {
		PostWithAuthor postWithAuthor = postRepository.getPostWithAuthor(1L);
		Assertions.assertEquals("Chinna", postWithAuthor.getAuthor().getFirstName());
	}

	@Test
	public void getPostInfoWithConstrutorExpJpaTest() {
		List<PostInfo> list = postRepository.getPostInfoWithConstrutorExp();
		Assertions.assertEquals(2, list.get(0).getViewCount());
	}

	@Test
	public void getPostInfoWithoutJoinClauseJpaTest() {
		List<PostInfo> list = postRepository.getPostInfoWithoutJoinClause();
		Assertions.assertEquals(2, list.get(0).getViewCount());
	}

	@Test
	public void getPostWithAuthorTest() {
		PostWithAuthorDTO postWithAuthor = postInfoDAO.getPostWithAuthor(1L);
		Assertions.assertEquals("Chinna", postWithAuthor.getAuthor().getFirstName());
	}

	@Test
	public void getPostInfoWithoutJoinClauseTest() {
		List<PostInfo> list = postInfoDAO.getPostInfoWithoutJoinClause();
		Assertions.assertEquals(2, list.get(0).getViewCount());
	}

	@Test
	public void getPostInfoWithConstrutorExpTest() {
		List<PostInfo> list = postInfoDAO.getPostInfoWithConstrutorExp();
		Assertions.assertEquals(2, list.get(0).getViewCount());
	}
}
