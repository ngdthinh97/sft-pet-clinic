package tng.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import tng.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
