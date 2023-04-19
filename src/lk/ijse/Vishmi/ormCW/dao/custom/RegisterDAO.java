package lk.ijse.Vishmi.ormCW.dao.custom;

import lk.ijse.Vishmi.ormCW.dao.CrudDAO;
import lk.ijse.Vishmi.ormCW.entity.Reservation;

public interface RegisterDAO extends CrudDAO<Reservation,String> {
    boolean updateUsingId(String id,String status) throws Exception;
}
