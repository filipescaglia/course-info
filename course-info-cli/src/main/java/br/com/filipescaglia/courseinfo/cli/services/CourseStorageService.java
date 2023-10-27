package br.com.filipescaglia.courseinfo.cli.services;

import br.com.filipescaglia.courseinfo.domain.Course;
import br.com.filipescaglia.courseinfo.repository.CourseRepository;

import java.util.List;

public class CourseStorageService {

    private static final String PS_BASE_URL = "https://app.pluralsight.com";

    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralsightCourse> psCourses) {
        List<Course> courses = psCourses
                .stream()
                .map(c -> new Course(c.id(), c.title(), c.durationInMinutes(), PS_BASE_URL + c.contentUrl()))
                .toList();
        courseRepository.saveCourses(courses);
    }

}
