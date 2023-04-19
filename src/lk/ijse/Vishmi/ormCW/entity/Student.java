package lk.ijse.Vishmi.ormCW.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    private String studentId;
    private String name;
    private String age;
    private String address;
    private String dob;
    private String gender;
    private String contact;


    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new ArrayList<>();
}
