package gr.aueb.cf.springhello5.rest;

import gr.aueb.cf.springhello5.dto.StudentReadOnlyDTO;
import gr.aueb.cf.springhello5.mapper.Mapper;
import gr.aueb.cf.springhello5.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloRestController {

    @GetMapping("/hello")
    //@RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello CF!!!";
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentReadOnlyDTO> getOneStudent(@PathVariable("id") Long id) {
        Student student = new Student(1L, "Bob", "Dylan"); // returned from service layer

        StudentReadOnlyDTO dto = Mapper.mapToReadOnlyDTO(student);
        //return new ResponseEntity<>(dto, HttpStatus.OK);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentReadOnlyDTO>> getAllStudents() {
        List<Student> students = List.of(new Student(1L, "Alice", "W."), new Student(2L, "Bob", "D."),
                new Student(3L, "Costas", "A."), new Student(4L, "George", "P.")); // returned from service layer

        List<StudentReadOnlyDTO> readOnlyDTOs = new ArrayList<>();
        for (Student student : students) {
            readOnlyDTOs.add(Mapper.mapToReadOnlyDTO(student));
        }
        //return new ResponseEntity<>(readOnlyDTOs, HttpStatus.OK);
        return ResponseEntity.ok(readOnlyDTOs);
    }
}
