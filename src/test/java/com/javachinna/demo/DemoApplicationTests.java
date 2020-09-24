package com.javachinna.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

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
		assertEquals("Chinna", postWithAuthor.getAuthor().getFirstName());
	}

	@Test
	public void getPostInfoWithConstrutorExpJpaTest() {
		List<PostInfo> list = postRepository.getPostInfoWithConstrutorExp();
		assertThat(list).isNotEmpty();
	}

	@Test
	public void getPostInfoWithoutJoinClauseJpaTest() {
		List<PostInfo> list = postRepository.getPostInfoWithoutJoinClause();
		assertThat(list).isNotEmpty();
	}

	@Test
	public void getPostWithAuthorTest() {
		PostWithAuthorDTO postWithAuthor = postInfoDAO.getPostWithAuthor(1L);
		assertEquals("Chinna", postWithAuthor.getAuthor().getFirstName());
	}

	@Test
	public void getPostInfoWithoutJoinClauseTest() {
		List<PostInfo> list = postInfoDAO.getPostInfoWithoutJoinClause();
		assertThat(list).isNotEmpty();
	}

	@Test
	public void getPostInfoWithConstrutorExpTest() {
		List<PostInfo> list = postInfoDAO.getPostInfoWithConstrutorExp();
		assertThat(list).isNotEmpty();
	}
}
