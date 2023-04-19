package lk.ijse.Vishmi.ormCW.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Vishmi.ormCW.dao.DaoFactory;
import lk.ijse.Vishmi.ormCW.dao.custom.RegisterDAO;
import lk.ijse.Vishmi.ormCW.dao.custom.RoomDAO;
import lk.ijse.Vishmi.ormCW.dao.custom.StudentDAO;
import lk.ijse.Vishmi.ormCW.dto.CustomDTO;
import lk.ijse.Vishmi.ormCW.dto.RoomDTO;
import lk.ijse.Vishmi.ormCW.dto.StudentDTO;
import lk.ijse.Vishmi.ormCW.entity.Reservation;
import lk.ijse.Vishmi.ormCW.entity.Room;
import lk.ijse.Vishmi.ormCW.entity.Student;
import lk.ijse.Vishmi.ormCW.service.custom.RegistrationService;
import lk.ijse.Vishmi.ormCW.util.FactoryConfiguration;
import lk.ijse.Vishmi.ormCW.view.tm.CartTM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServiceImpl  implements RegistrationService {
    private final StudentDAO studentDAO = (StudentDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.ROOM);
    private final RegisterDAO registrationDAO = (RegisterDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.REGISTRATION);

    @Override
    public void Register(ObservableList<CartTM> list, String studentId, String lblId) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            ObservableList<CartTM> items = list;
            for (CartTM tm:items
            ) {
                List<Room> roomDetailUsingId = roomDAO.getRoomDetailUsingId(tm.getRoomTypeId());
                Room room = new Room();

                for (Room r:roomDetailUsingId
                ) {
                    room.setRoomTypeId(r.getRoomTypeId());
                    room.setRoomType(r.getRoomType());
                    room.setNoOfRooms(r.getNoOfRooms());
                    room.setKeyMoney(r.getKeyMoney());

                }

                List<Student> studentDetailUsingId = studentDAO.getStudentDetailsUsingId(studentId);

                Student student = new Student();
                for (Student s:studentDetailUsingId
                ) {
                    student.setStudentId(s.getStudentId());
                    student.setName(s.getName());
                    student.setAge(s.getAge());
                    student.setAddress(s.getAddress());
                    student.setDob(s.getDob());
                    student.setGender(s.getGender());
                    student.setContact(s.getContact());

                }

                Reservation r = new Reservation();
                r.setRegId(lblId);
                r.setStudentId(lblId);
                r.setName(tm.getStatus());
                r.setRoom(room);
                r.setStudent(student);

                session.save(r);
                session.update(room);
                transaction.commit();

            }

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }


        session.close();
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

    @Override
    public List<RoomDTO> getAllRooms() throws IOException {
        List<Room> all = roomDAO.getAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        for (Room room:all
        ) {
            roomDTOS.add(
                    new RoomDTO(room.getRoomTypeId(),room.getRoomType(),room.getNoOfRooms(),room.getKeyMoney())
            );
        }
        return roomDTOS;
    }

    @Override
    public List<RoomDTO> getRoomDetailUsingId(String id) throws Exception {
        List<Room> list = roomDAO.getRoomDetailUsingId(id);
        List<RoomDTO> dtoList = new ArrayList<>();
        for (Room roomDTO:list
        ) {
            dtoList.add(
                    new RoomDTO(roomDTO.getRoomTypeId(),roomDTO.getRoomType(),roomDTO.getNoOfRooms(),roomDTO.getKeyMoney())
            );
        }
        return dtoList;
    }

    @Override
    public List<StudentDTO> getStudentDetailUsingId(String id) throws Exception {
        List<Student> list = studentDAO.getStudentDetailsUsingId(id);
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student student:list
        ) {
            dtoList.add(
                    new StudentDTO(student.getStudentId(),student.getName(),student.getAge(),student.getAddress(),student.getDob(),student.getGender(),student.getContact())
            );
        }
        return dtoList;
    }

    @Override
    public String generateRegistrationId() throws Exception {
        String id = registrationDAO.generateId();
        return id;
    }
}
