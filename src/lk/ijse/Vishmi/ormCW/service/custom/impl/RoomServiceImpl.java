package lk.ijse.Vishmi.ormCW.service.custom.impl;

import lk.ijse.Vishmi.ormCW.dao.DaoFactory;
import lk.ijse.Vishmi.ormCW.dao.custom.RoomDAO;
import lk.ijse.Vishmi.ormCW.dto.RoomDTO;
import lk.ijse.Vishmi.ormCW.entity.Room;
import lk.ijse.Vishmi.ormCW.service.custom.RoomService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private final RoomDAO roomDAO = (RoomDAO) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTypes.ROOM);

    @Override
    public boolean saveRoom(RoomDTO dto) throws Exception {
        return roomDAO.save(new Room(dto.getRoomTypeId(),dto.getRoomType(),dto.getNoOfRooms(),dto.getKeyMoney()));

    }

    @Override
    public boolean updateRoom(RoomDTO dto) throws Exception {
        return roomDAO.update(new Room(dto.getRoomTypeId(),dto.getRoomType(),dto.getNoOfRooms(),dto.getKeyMoney()));
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomDAO.delete(id);
    }

    @Override
    public List<RoomDTO> getAllRooms() throws IOException {
        List<Room> all = roomDAO.getAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        for (Room room:all
        ) {
            roomDTOS.add(
                    new RoomDTO(room.getRoomTypeId(),room.getRoomType(),room.getNoOfRooms(),room.getKeyMoney())
            );
        }
        return roomDTOS;
    }
}
