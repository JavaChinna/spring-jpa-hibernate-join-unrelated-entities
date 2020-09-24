package com.javachinna.model;

import lombok.Value;

@Value
public class PostWithAuthorDTO {
	private Post post;
	private Author author;
}
