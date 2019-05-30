package gamat.interview.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("student")
public class Student extends Person {

    @Column
    @ManyToMany
    private Set<Subject> subjects;

    public Set<Subject> getSubject() {
        return subjects;
    }

    public void setSubject(Set<Subject> subjects) {
        this.subjects = subjects;
    }

}
