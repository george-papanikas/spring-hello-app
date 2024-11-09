package gr.aueb.cf.springhello5.mapper;

import gr.aueb.cf.springhello5.dto.StudentReadOnlyDTO;
import gr.aueb.cf.springhello5.model.Student;

public class Mapper {

    private Mapper() {}

    public static StudentReadOnlyDTO mapToReadOnlyDTO(Student student) {
        return new StudentReadOnlyDTO(student.getId(), student.getFirstname(), student.getLastname());
    }
}
