package lk.ijse.Vishmi.ormCW.dao.custom.Impl;

import lk.ijse.Vishmi.ormCW.dao.custom.QueryDAO;
import lk.ijse.Vishmi.ormCW.entity.Student;
import lk.ijse.Vishmi.ormCW.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public boolean save(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public List<Student> getAll() throws IOException {
        return null;
    }

    @Override
    public String generateId() throws Exception {
        return null;
    }

    @Override
    public List<Object[]> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception {
        /*Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT r.regId,s.studentId,s.name,ro.roomId,ro.roomType,ro.keyMoney,r.paymentStatus,r.date FROM Reservation r JOIN Student s ON r.studentId = s.studentId JOIN Room ro ON r.room =ro.roomTypId WHERE r.paymentStatus= : y");


        List<Object[]> list = query.setParameter("y", "Paid Later").list();

        transaction.commit();
        session.close();
        return list;*/
        return null;
    }

    @Override
    public List<Student> getStudentDetailsUsingId(String id) throws Exception {
        return null;
    }
}
