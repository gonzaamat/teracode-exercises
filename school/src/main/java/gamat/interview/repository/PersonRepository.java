package gamat.interview.repository;

import gamat.interview.model.Person;
import gamat.interview.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "SELECT * FROM Person AS p WHERE p.person_type = 'student'", nativeQuery = true)
    List<Student> getAllStudents();

    Optional<Set<Student>> findBySubjects_Id(Long id);

}

