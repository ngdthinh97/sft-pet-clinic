package tng.springframework.sfgpetclinic.services;



import tng.springframework.sfgpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
	
	Vet findByLastName(String lastName);
	
}
