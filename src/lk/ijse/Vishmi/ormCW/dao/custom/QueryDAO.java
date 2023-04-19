package lk.ijse.Vishmi.ormCW.dao.custom;

import java.util.List;

public interface QueryDAO extends StudentDAO{
    List<Object[]> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception;
}
