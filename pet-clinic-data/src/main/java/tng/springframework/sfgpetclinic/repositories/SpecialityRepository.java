package tng.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import tng.springframework.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long>{
	
}
