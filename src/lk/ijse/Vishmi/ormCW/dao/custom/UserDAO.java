package lk.ijse.Vishmi.ormCW.dao.custom;

import lk.ijse.Vishmi.ormCW.dao.CrudDAO;
import lk.ijse.Vishmi.ormCW.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User> getUserDetails(String userName, String pwd) throws Exception;
}
