package lk.ijse.Vishmi.ormCW.service.custom.impl;

import lk.ijse.Vishmi.ormCW.dao.DaoFactory;
import lk.ijse.Vishmi.ormCW.dao.custom.StudentDAO;
import lk.ijse.Vishmi.ormCW.dto.StudentDTO;
import lk.ijse.Vishmi.ormCW.entity.Student;
import lk.ijse.Vishmi.ormCW.service.custom.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO = (StudentDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.STUDENT);


    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return studentDAO.save(new Student(dto.getStudentId(),dto.getName(),dto.getAge(),dto.getAddress(),dto.getDob(),dto.getGender(),dto.getContact()));

    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return studentDAO.update(new Student(dto.getStudentId(),dto.getName(),dto.getAge(),dto.getAddress(),dto.getDob(),dto.getGender(),dto.getContact()));

    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public String generateStudentId() throws Exception {
        String id = studentDAO.generateId();
        return id;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws IOException {
        List<Student> all = studentDAO.getAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for (Student s:all
        ) {
            dtos.add(
                    new StudentDTO(s.getStudentId(),s.getName(),s.getAge(),s.getAddress(),s.getDob(),s.getGender(),s.getContact())
            );

        }
        return dtos;
    }
}
