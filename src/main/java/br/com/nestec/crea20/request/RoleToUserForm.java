package br.com.nestec.crea20.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RoleToUserForm {
    private String cpf;
    private String rolename;
    private Long userId;
    private Long roleId;
}
