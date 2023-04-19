package lk.ijse.Vishmi.ormCW.service.custom.impl;

import lk.ijse.Vishmi.ormCW.dao.DaoFactory;
import lk.ijse.Vishmi.ormCW.dao.custom.UserDAO;
import lk.ijse.Vishmi.ormCW.dto.UserDTO;
import lk.ijse.Vishmi.ormCW.entity.User;
import lk.ijse.Vishmi.ormCW.service.custom.LogService;

import java.util.ArrayList;
import java.util.List;

public class LogServiceImpl  implements LogService {
    private final UserDAO userDAO = (UserDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.USER);

    @Override
    public List<UserDTO> getUserDetails(String userName, String password) throws Exception {

        List<User> list = UserDAO.getUserDetails(userName,password);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user:list
        ) {
            userDTOS.add(new UserDTO(user.getUserId(),user.getName(),user.getEmail(),user.getAddress(),user.getDob(),user.getContact(),user.getUserName(),user.getPassword()));
        }
        return userDTOS;
    }
}
