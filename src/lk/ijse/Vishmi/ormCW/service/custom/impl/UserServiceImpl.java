package lk.ijse.Vishmi.ormCW.service.custom.impl;

import lk.ijse.Vishmi.ormCW.dto.UserDTO;
import lk.ijse.Vishmi.ormCW.service.custom.UserService;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean saveUser(UserDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateUser(UserDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return false;
    }

    @Override
    public String generateUserId() throws Exception {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        return null;
    }
}
