package lk.ijse.Vishmi.ormCW.service.custom;

import lk.ijse.Vishmi.ormCW.dto.RoomDTO;
import lk.ijse.Vishmi.ormCW.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface RoomService extends SuperService {
    boolean saveRoom(RoomDTO dto) throws Exception;

    boolean updateRoom(RoomDTO dto) throws Exception;

    boolean deleteRoom(String id) throws Exception;

    List<RoomDTO> getAllRooms() throws IOException;
}
