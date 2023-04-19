package lk.ijse.Vishmi.ormCW.dao.custom;

import lk.ijse.Vishmi.ormCW.dao.CrudDAO;
import lk.ijse.Vishmi.ormCW.entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room,String> {
    List<Room> getRoomDetailUsingId(String id) throws Exception;
}
