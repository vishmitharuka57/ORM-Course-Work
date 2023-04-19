package lk.ijse.Vishmi.ormCW.service.custom;

import lk.ijse.Vishmi.ormCW.dto.UserDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface UserService extends SuperService {
    boolean saveUser(UserDTO dto) throws Exception;

    boolean updateUser(UserDTO dto) throws Exception;

    boolean deleteUser(String id) throws Exception;

    String generateUserId()throws Exception;

    List<UserDTO> getAllUsers() throws IOException;
}
