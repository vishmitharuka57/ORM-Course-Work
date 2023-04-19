package lk.ijse.Vishmi.ormCW.service.custom.impl;

import lk.ijse.Vishmi.ormCW.dao.DaoFactory;
import lk.ijse.Vishmi.ormCW.dao.custom.QueryDAO;
import lk.ijse.Vishmi.ormCW.dao.custom.RegisterDAO;
import lk.ijse.Vishmi.ormCW.dto.CustomDTO;
import lk.ijse.Vishmi.ormCW.dto.PaymentDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;
import lk.ijse.Vishmi.ormCW.service.custom.PendingKeyMoneyService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PendingKeyMoneyServiceImpl implements PendingKeyMoneyService {
    final private RegisterDAO registrationDAO = (RegisterDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.REGISTRATION);
    final private  QueryDAO queryDAO = (QueryDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.QUERYDAO);


    @Override
    public ArrayList<PaymentDTO> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception {
        List<Object[]> objects = queryDAO.getAllPendingKeyMoneyReservationsUsingReservationStatus();
        ArrayList<PaymentDTO> arrayList = new ArrayList<>();

        for (Object[] o:objects
        ) {
            arrayList.add(new PaymentDTO((String) o[0],(String) o[1],(String) o[2],(String) o[3],(String) o[4],(String) o[5],(String) o[6],(String) o[7]));
        }

        return arrayList;
    }

    @Override
    public boolean updateReservationUsingId(String id, String status) throws Exception {
        return registrationDAO.updateUsingId(id,status);
    }
}
