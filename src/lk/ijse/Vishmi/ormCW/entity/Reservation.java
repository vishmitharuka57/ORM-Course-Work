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
public class Reservation {
    @Id
    private String regId;
    private String studentId;
    private String name;
    private String campusName;
    private String duration;
    private String gender;
    private String roomId;
    private String contact;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name="roomTypeId")
    private Room room;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new ArrayList<>();
}
