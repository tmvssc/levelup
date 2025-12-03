package level.up.levelup.entidades;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String email;
    private boolean esAdmin;
}
