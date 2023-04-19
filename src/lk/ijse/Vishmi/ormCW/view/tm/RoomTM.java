package lk.ijse.Vishmi.ormCW.view.tm;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTM {
    private String roomTypeId;
    private String type;
    private double keyMoney;
    private int noOfRooms;
}
