package br.com.filipescaglia.courseinfo.repository;

import br.com.filipescaglia.courseinfo.domain.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    List<Course> getAllCourses();
}
