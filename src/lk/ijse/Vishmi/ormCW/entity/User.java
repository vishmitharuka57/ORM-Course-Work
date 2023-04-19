package lk.ijse.Vishmi.ormCW.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String address;
    private String dob;
    private String contact;
    private String userName;
    private String password;
}
