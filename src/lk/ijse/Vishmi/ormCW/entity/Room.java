package lk.ijse.Vishmi.ormCW.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {
    @Id
    private String roomTypeId;
    private String roomType;
    private String noOfRooms;
    private String KeyMoney;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new ArrayList<>();

}
