package com.spring.lms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.model.Chapters;
import com.spring.lms.model.Course;
import com.spring.lms.repository.ChaptersRepo;
import com.spring.lms.repository.CourseRepo;

@Service
@Transactional
public class ChapterService {

	@Autowired
	private ChaptersRepo chapRepo;

	@Autowired
	private CourseRepo courseRepo;

	public Chapters saveChapters(Chapters chapter) {
		Course courseId = courseRepo.findById(chapter.getCourseId()).orElse(null);
		chapter.setCourse(courseId);
		return chapRepo.save(chapter);
	}

	public List<Chapters> getChapters() {
		// TODO Auto-generated method stub
		return chapRepo.findAll();
	}

	public Chapters getChapterByName(String chapterName) {
		// TODO Auto-generated method stub
		return chapRepo.findBychapterName(chapterName);
	}

	public Chapters getChapter(int chapterId) {
		// TODO Auto-generated method stub
		return chapRepo.findById(chapterId).orElse(null);
	}

	public Chapters updateChapter(Chapters chapter) {
		// TODO Auto-generated method stub

		Chapters existingChapters = chapRepo.findById(chapter.getChapterId()).orElse(null);
		existingChapters.setChapterName(chapter.getChapterName());
		existingChapters.setChapterlink(chapter.getChapterlink());
		existingChapters.setChapterDate(chapter.getChapterDate());
		return chapRepo.save(existingChapters);
	}

	public String deleteChapter(int chapterId) {
		// TODO Auto-generated method stub
		chapRepo.deleteById(chapterId);
		return null;
	}

	public List<Chapters> getChaptersList(int courseId) {
		// TODO Auto-generated method stub
		return (List<Chapters>) chapRepo.findByCourseCourseId(courseId);
	}
}
