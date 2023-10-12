package br.com.filipescaglia.courseinfo.cli;

import br.com.filipescaglia.courseinfo.cli.services.CourseRetrievalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRetriever {

    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("CourseRetriever started!");
        if (args.length == 0) {
            LOG.warn("Please provide an authour name as first argument.");
            return;
        }

        try {
            retrieverCourses(args[0]);
        } catch (Exception e) {
            LOG.error("Unexpected error", e);
        }
    }

    private static void retrieverCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();

        String coursesToStore = courseRetrievalService.getCoursesFor(authorId);
        LOG.info("Retrieved the following courses {}", coursesToStore);
    }

}
