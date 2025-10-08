package Service;

import Entity.Course;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse (int id);

    public Course addCourse(Course course);

    public void updateCourse(Course course);

    public void deleteCourse (int id);

}
