package lk.ijse.Vishmi.ormCW.dao.custom.Impl;

import lk.ijse.Vishmi.ormCW.dao.custom.RoomDAO;
import lk.ijse.Vishmi.ormCW.entity.Room;
import lk.ijse.Vishmi.ormCW.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room room) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(room);

        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public boolean update(Room room) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(room);

        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class,id);
        session.delete(room);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Room> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Room ");
        List<Room> list = query.list();


        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public String generateId() throws Exception {
        return null;
    }

    @Override
    public List<Room> getRoomDetailUsingId(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Room WHERE roomTypeId= :id ");
        query.setParameter("id", id);

        List<Room> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }
}
