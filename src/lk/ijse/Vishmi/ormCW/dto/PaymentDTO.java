package lk.ijse.Vishmi.ormCW.dto;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String regId;
    private String studentId;
    private String name;
    private String roomId;
    private String roomType;
    private String regDate;
    private String KeyMoney;
    private String status;
}
