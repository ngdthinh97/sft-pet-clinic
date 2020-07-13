package tng.springframework.sfgpetclinic.services;

import java.util.Set;

import tng.springframework.sfgpetclinic.model.Vet;

public interface VetService {
	
	Vet findByLastName(String lastName);
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
