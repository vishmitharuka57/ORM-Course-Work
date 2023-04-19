package lk.ijse.Vishmi.ormCW.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.Vishmi.ormCW.dto.CustomDTO;
import lk.ijse.Vishmi.ormCW.dto.RoomDTO;
import lk.ijse.Vishmi.ormCW.dto.StudentDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;
import lk.ijse.Vishmi.ormCW.view.tm.CartTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface RegistrationService extends SuperService {
    void Register(ObservableList<CartTM> list, String studentId, String lblId)throws Exception;
    List<StudentDTO> getAllStudents() throws IOException;
    List<RoomDTO> getAllRooms() throws IOException;
    List<RoomDTO> getRoomDetailUsingId(String id) throws Exception;
    List<StudentDTO> getStudentDetailUsingId(String id) throws Exception;
    String generateRegistrationId()throws Exception;


}
