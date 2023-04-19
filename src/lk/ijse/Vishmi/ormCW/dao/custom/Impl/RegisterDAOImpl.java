package lk.ijse.Vishmi.ormCW.dao.custom.Impl;

import lk.ijse.Vishmi.ormCW.dao.custom.RegisterDAO;
import lk.ijse.Vishmi.ormCW.entity.Reservation;
import lk.ijse.Vishmi.ormCW.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean save(Reservation reservation) throws Exception {
        return false;
    }

    @Override
    public boolean update(Reservation reservation) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public List<Reservation> getAll() throws IOException {
        return null;
    }

    @Override
    public String generateId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List resultList = session.createSQLQuery("SELECT * FROM Reservation ORDER BY regId DESC LIMIT 1").addEntity(Reservation.class).getResultList();
        transaction.commit();
        session.close();

        return resultList.size()==0?"RS000":((Reservation)resultList.get(0)).getRegId();

    }

    @Override
    public boolean updateUsingId(String id, String status) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Reservation SET campusName = :s WHERE regId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("s",status );
        query.setParameter("id", id);

        int i = query.executeUpdate();

        transaction.commit();
        session.close();
        return i>0;
    }
}
