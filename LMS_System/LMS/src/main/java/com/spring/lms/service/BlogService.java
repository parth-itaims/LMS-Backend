package com.spring.lms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.lms.model.Blog;
import com.spring.lms.model.Chapters;
import com.spring.lms.model.User;
import com.spring.lms.repository.BlogRepo;

@Service
@Transactional
public class BlogService {

	@Autowired
	private BlogRepo blogRepo;

	public Blog saveBlog(Blog blog) {
		return blogRepo.save(blog);
	}

	public List<Blog> getBlog() {
		return blogRepo.findAll();
	}

	public Blog getBlogByid(int blogId) {
		// TODO Auto-generated method stub
		return blogRepo.findById(blogId).orElse(null);
	}

	public Blog updateBlog(Blog blog) {

		Blog existingData = blogRepo.findById(blog.getBlogId()).orElse(null);
		existingData.setBlogTitle(blog.getBlogTitle());
		existingData.setBlogBody(blog.getBlogBody());
		existingData.setBlogDate(blog.getBlogDate());
		return blogRepo.save(existingData);

	}

	public String deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		blogRepo.deleteById(blogId);

		return null;
	}

	public boolean saveblogImage(int blogId, MultipartFile blogImage) {
		// TODO Auto-generated method stub
		Optional<Blog> blogObj = blogRepo.findById(blogId);
		if (blogObj.isPresent()) {
			Blog obj = blogObj.get();
			try {
				obj.setBlogImage(blogImage.getBytes());
				blogRepo.save(obj);
				return true;
			} catch (Exception e) {
				System.out.println("\nError during file upload... " + e.getMessage());
				e.printStackTrace();
				return false;
			}

		} else
			return false;
	}

}
