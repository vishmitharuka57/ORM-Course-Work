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
public class Payment {
    @Id
    private String regId;
    private String studentId;
    private String name;
    private String roomId;
    private String roomType;
    private String regDate;
    private String KeyMoney;
    private String paymentStatus;
}
