package br.com.nestec.crea20.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RoleToUserForm {
    private String username;
    private String rolename;
}
