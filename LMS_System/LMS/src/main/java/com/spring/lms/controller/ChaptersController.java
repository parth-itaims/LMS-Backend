package com.spring.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.lms.model.Chapters;
import com.spring.lms.model.Course;
import com.spring.lms.service.ChapterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChaptersController {
	
	@Autowired
	private ChapterService chapterService;

	@PostMapping("/chapters")
	public Chapters saveChapters(@RequestBody Chapters chapter)
	{
		 return chapterService.saveChapters(chapter);
		// System.out.println(course.getChapters());
			
	}
	
	@GetMapping("/chapters")
	public List<Chapters> getCourse()
	{
		return chapterService.getChapters();
	}
	
	@GetMapping("/chapters/{chapterId}")
	public Chapters getChapter(@PathVariable int chapterId)
	{
		return chapterService.getChapter(chapterId);
	}
	
//	@GetMapping("/chapters/{chapterName}")
//	public Chapters getChapterByName(@PathVariable String chapterName)
//	{
//		return chapterService.getChapterByName(chapterName);
//	}
	
	@PutMapping("/chapters")
	public Chapters updateCourse(@RequestBody Chapters chapter)
	{
		return chapterService.updateChapter(chapter);
	}
	
	@DeleteMapping("/chapters/{chapterId}")
	public String deleteChapter(@PathVariable int chapterId)
	{
			return chapterService.deleteChapter(chapterId);
	}
		
	@GetMapping("/chapter/{courseId}")
	public List<Chapters> getChaptersList(@PathVariable int courseId)
	{
			return chapterService.getChaptersList(courseId);
	}


}
