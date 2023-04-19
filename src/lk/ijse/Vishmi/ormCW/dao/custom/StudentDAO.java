package lk.ijse.Vishmi.ormCW.dao.custom;

import lk.ijse.Vishmi.ormCW.dao.CrudDAO;
import lk.ijse.Vishmi.ormCW.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    List<Student> getStudentDetailsUsingId(String id) throws Exception;
}
