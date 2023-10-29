package br.com.filipescaglia.courseinfo.cli.services;

import br.com.filipescaglia.courseinfo.domain.Course;
import br.com.filipescaglia.courseinfo.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseStorageService {

    private static final String PS_BASE_URL = "https://app.pluralsight.com";

    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralsightCourse> psCourses) {
        for (PluralsightCourse pCourse : psCourses) {
            Course course = new Course(
                    pCourse.id(),
                    pCourse.title(),
                    pCourse.durationInMinutes(),
                    PS_BASE_URL + pCourse.contentUrl(),
                    Optional.empty()
            );
            courseRepository.saveCourse(course);
        }
    }

}
