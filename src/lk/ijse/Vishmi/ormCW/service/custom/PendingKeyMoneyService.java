package lk.ijse.Vishmi.ormCW.service.custom;

import lk.ijse.Vishmi.ormCW.dto.CustomDTO;
import lk.ijse.Vishmi.ormCW.dto.PaymentDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;

import java.util.ArrayList;

public interface PendingKeyMoneyService extends SuperService {
    ArrayList<PaymentDTO> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception;
    boolean updateReservationUsingId(String id, String status) throws Exception;

}
