package com.javachinna.model;

import lombok.Value;

@Value
public class PostInfo {
	String title, authorName;
	Long viewCount;
}
