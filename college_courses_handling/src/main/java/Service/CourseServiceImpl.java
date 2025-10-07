package Service;

import Entity.Course;
import Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Autowired
    public CourseRepository courseRepository;

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(1, "Java", "The go-to language in big tech."));
        list.add(new Course(2, "Python", "The go-to language of the present world"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(int id) {
        Course c = null;
        for (Course course : list){
            if (course.getId() == id){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse (Course course){
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse (Course course){
        list.forEach(element -> {
            if (element.getId() == course.getId()){
                element.setName(course.getName());
                element.setDetail(course.getDetail());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(int id){
        list.removeIf(course -> course.getId() == id);
    }
}
