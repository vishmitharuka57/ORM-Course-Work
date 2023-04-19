package lk.ijse.Vishmi.ormCW.view.tm;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentTM {
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;
}
