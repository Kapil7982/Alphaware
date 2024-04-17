package com.blogApp.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.models.Post;
import com.blogApp.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
    private PostRepository postRepository;
	
	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
	}

	@Override
	public Post createPost(Post post) {
		post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
	}

	@Override
	public Post updatePost(Long id, Post updatedPost) {
		Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            existingPost.setUpdatedAt(LocalDateTime.now());
            return postRepository.save(existingPost);
        }
        return null;
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public List<Post> getFeedPosts() {
		 LocalDateTime startOfDay = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
	        LocalDateTime endOfDay = startOfDay.plusDays(1);
	        return postRepository.findByCreatedAtBetween(startOfDay, endOfDay);
	}

}
