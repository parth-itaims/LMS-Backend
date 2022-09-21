package com.spring.lms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.model.Blog;
import com.spring.lms.service.BlogService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {
	
	
	@Autowired
	private BlogService blogService;
	
	@PostMapping("/blog")
	public Blog saveBlog(@RequestBody Blog blog)
	{
		return blogService.saveBlog(blog);
	}
	
	@GetMapping("/blog")
	public List<Blog> getBlog()
	{
		return blogService.getBlog();
	}
	
	@GetMapping("/blog/{blogId}")
	public Blog getBlog(@PathVariable int blogId)
	{
		return blogService.getBlogByid(blogId);
	}
	
	@PutMapping("/blog")
	public Blog updateBlog(@RequestBody Blog blog)
	{
		return blogService.updateBlog(blog);
	}
	
	@DeleteMapping("/blog/{blogId}")
	public String deleteBlog(@PathVariable int blogId)
	{
		return blogService.deleteBlog(blogId);
	}

	@PostMapping("/blog/save-blog/{blogId}")
	public boolean uploadblogImage(@PathVariable("blogId") int blogId,
			@RequestParam("blogImage") MultipartFile blogImage) throws IOException {
		System.out.println("\nUpload Blog image called....\n");
		return blogService.saveblogImage(blogId, blogImage);
	}
}
