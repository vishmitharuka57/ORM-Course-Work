package lk.ijse.Vishmi.ormCW.service.custom;

import lk.ijse.Vishmi.ormCW.dto.StudentDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface StudentService extends SuperService {
    boolean saveStudent(StudentDTO dto) throws Exception;

    boolean updateStudent(StudentDTO dto) throws Exception;

    boolean deleteStudent(String id) throws Exception;

    String generateStudentId()throws Exception;

    List<StudentDTO> getAllStudents() throws IOException;
}
