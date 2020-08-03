package tng.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import tng.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
