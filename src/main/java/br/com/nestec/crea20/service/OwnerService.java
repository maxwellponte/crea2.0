package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Owners;

import java.util.List;

public interface OwnerService {
    Owners saveOwner(Owners owner);
    void deleteOwner(String cpfcnpj);
    List<Owners> getOwners(String nomeCnpj);
}
