package Controller;

import Entity.Course;
import Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse (@PathVariable String id){
        return this.courseService.getCourse(Integer.parseInt(id));
    }

    @PostMapping("/courses/addCourse")
    public Course addCourse (@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses/updateCourse")
    public Course updateCourse (@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse (@RequestBody String id){
        try{
            this.courseService.deleteCourse(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
