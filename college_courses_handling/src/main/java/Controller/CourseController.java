package Controller;

import Entity.Course;
import Service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    // GET
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    // GET by Id
    @GetMapping("/courses/{courseID}")
    public Course getCourse (@PathVariable String id){
        return this.courseService.getCourse(Integer.parseInt(id));
    }

    // ADD new course
    @PostMapping("/courses/addCourse")
    public Course addCourse (@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    // Update the existing course
    @PutMapping("/courses/updateCourse")
    public ResponseEntity<HttpStatus> updateCourse (@RequestBody Course course){
        try{
            this.courseService.updateCourse(course);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete the course
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
