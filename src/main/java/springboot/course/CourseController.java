package springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	CourseService service;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return service.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return service.getCourse(id);
	}
	
	/**
	 * add, requestbody is message body sent
	 * @param course
	 */
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		// topicId is matter, other is not necessary
		course.setTopic(new Topic(topicId, "", ""));
		service.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		// topicId is matter, other is not necessary
		course.setTopic(new Topic(topicId, "", ""));
		service.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String topicId, @PathVariable String id) {
		service.deleteCourse(id);
	}
	
}
