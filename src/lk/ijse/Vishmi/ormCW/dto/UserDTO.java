package lk.ijse.Vishmi.ormCW.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private String userId;
    private String name;
    private String email;
    private String address;
    private String dob;
    private String contact;
    private String userName;
    private String password;
}
