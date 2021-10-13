package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Owner;
import br.com.nestec.crea20.repository.OwnerIRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class OwnerServiceImp implements OwnerService{
    @Autowired
    OwnerIRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        log.info("salvando o proprietário com o cpf/cnpj {} no banco de dados",owner.getCpfCnpj());
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(String cpfcnpj) {
        log.info("deletando o proprietário com o cpf/cnpj {} do banco de dados",cpfcnpj);
        ownerRepository.delete(ownerRepository.findByCpfCnpj(cpfcnpj));
    }

    @Override
    public List<Owner> getOwners() {
        log.info("listando todos os proprietário do banco de dados");
        return ownerRepository.findAll();
    }
}
