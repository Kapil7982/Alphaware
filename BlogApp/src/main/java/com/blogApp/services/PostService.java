package com.blogApp.services;

import java.util.List;

import com.blogApp.models.Post;

public interface PostService {

	public List<Post> getAllPosts();
	public Post getPostById(Long id);
	public Post createPost(Post post);
	public Post updatePost(Long id, Post post);
	public void deletePost(Long id);
	public List<Post> getFeedPosts();
}
