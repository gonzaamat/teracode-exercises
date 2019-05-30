package gamat.interview.controller;

import gamat.interview.model.Student;
import gamat.interview.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/students", produces = "application/json")
    public ResponseEntity getStudentsGroupedByLastName() {
        Map<Character, List<Student>> groupedStudents = personService.getStudentsGroupByLastname();
        return groupedStudents != null ? ResponseEntity.ok(groupedStudents) :  new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/students/{subjectId}", produces = "application/json")
    public ResponseEntity getStudentsBySubject(@PathVariable Long subjectId) {
        Optional<Set<Student>> students = personService.getStudentsBySubject(subjectId);
        return students.isPresent() ? ResponseEntity.ok(students) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
