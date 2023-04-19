package lk.ijse.Vishmi.ormCW.service.custom;

import lk.ijse.Vishmi.ormCW.dto.UserDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;

import java.util.List;

public interface LogService extends SuperService {
    List<UserDTO> getUserDetails(String userName, String password) throws Exception;
}
