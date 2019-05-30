package gamat.interview.service;

import gamat.interview.model.Student;
import gamat.interview.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Map<Character, List<Student>> getStudentsGroupByLastname() {
        Map<Character, List<Student>> groupedStudents = new HashMap<>();
        Optional<List<Student>> optionalStudents = Optional.ofNullable(personRepository.getAllStudents());
        if (optionalStudents.isPresent()){
            optionalStudents.get().forEach(student -> {
                String lastname = student.getLastname();
                Character firstLetter = lastname.charAt(0);
                if (groupedStudents.containsKey(firstLetter)) {
                    groupedStudents.get(firstLetter).add(student);
                } else {
                    groupedStudents.put(firstLetter, Arrays.asList(student));
                }
            });
            return groupedStudents;
        }
        return null;
    }

    public Optional<Set<Student>> getStudentsBySubject(Long id) {
        return personRepository.findBySubjects_Id(id);
    }

}
