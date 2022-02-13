package com.slimjava.firstspringboot.course;

import com.slimjava.firstspringboot.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses (@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse (@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse (@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }


    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse (@RequestBody Course course, @PathVariable String topicId,  @PathVariable String id) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, id);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteTopic (@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
