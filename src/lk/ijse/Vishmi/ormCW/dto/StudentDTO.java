package lk.ijse.Vishmi.ormCW.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private String studentId;
    private String name;
    private String age;
    private String address;
    private String dob;
    private String gender;
    private String contact;
}
