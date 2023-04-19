package lk.ijse.Vishmi.ormCW.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomDTO {
    private String regId;
    private String studentId;
    private String name;
    private String campusName;
    private String duration;
    private String gender;
    private String roomId;
    private String contact;
}
