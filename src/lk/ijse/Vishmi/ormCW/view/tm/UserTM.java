package lk.ijse.Vishmi.ormCW.view.tm;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserTM {
    private String userId;
    private String name;
    private String contact;
    private String email;
    private String userName;
    private String password;
}
