package br.com.filipescaglia.courseinfo.repository;

import br.com.filipescaglia.courseinfo.domain.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    void saveCourses(List<Course> courses);

    List<Course> getAllCourses();

    static CourseRepository openCourseRepository(String databaseFile) {
        return new CourseJdbcRepository(databaseFile);
    }
}
