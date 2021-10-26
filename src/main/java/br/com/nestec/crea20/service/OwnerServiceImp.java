package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Owners;
import br.com.nestec.crea20.repository.OwnerIRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class OwnerServiceImp implements OwnerService {
    @Autowired
    OwnerIRepository ownerRepository;

    @Override
    public Owners saveOwner(Owners owner) {
        log.info("salvando o proprietário com o cpf/cnpj {} no banco de dados", owner.getCpfCnpj());
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(String cpfcnpj) {
        log.info("deletando o proprietário com o cpf/cnpj {} do banco de dados", cpfcnpj);
        ownerRepository.delete(ownerRepository.findByCpfCnpj(cpfcnpj));
    }

    @Override
    public List<Owners> getOwners(String nomeCnpj) {
        try {
            log.info("listando o(s) proprietário(s) com o nome ou cnpj: {}", nomeCnpj);
            List<Owners> lp = ownerRepository.findByNameContaining(nomeCnpj);
            System.out.println("lp: " + lp);
            if (lp.size() == 0) {
                lp = Collections.singletonList(ownerRepository.findByCpfCnpj(nomeCnpj));
            }
            return lp;
        } catch (Exception e) {
            return ownerRepository.findAll();
        }
    }
}