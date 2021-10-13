package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.Owner;

import java.util.List;

public interface OwnerService {
    Owner saveOwner(Owner owner);
    void deleteOwner(String cpfcnpj);
    List<Owner> getOwners();
}
