package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.model.Course;
import uz.mohirdev.lesson.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

//    @GetMapping("/students")
//   // public String hello(){
//    public ResponseEntity hello(){                             1-usul
//       // return "Hello world mohirdev";
//        return ResponseEntity.ok("Hello world mohirdev");
//    }

    @RequestMapping(value = "/students")
    public ResponseEntity hello(){                                          //2-usul
        return ResponseEntity.ok("Hello mohirdev");
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }
    @PostMapping("/students/list")
    public ResponseEntity createAll(@RequestBody List<Student> students){
        return ResponseEntity.ok(students);
    }
    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student){
        student.setLastName("test uchun");
        return ResponseEntity.ok(student);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity updateSecond(@PathVariable Long id, @RequestBody Student student){
        student.setLastName("test uchun");
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id){
        Student student = new Student();
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getAll(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam Integer age){
        List<Student> students = new ArrayList<>();
        Course course = new Course();
        course.setId(2L);
        course.setName("Test course");
        students.add(new Student(id, name, lastName, age, course));
        students.add(new Student(3L, "name", "lastName", 34, course));
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(id+ " Ma'lumot o'chirildi");
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity patchUpdate(@PathVariable Long id,
                                      @RequestBody Student student){
        return ResponseEntity.ok(student);
    }
}
