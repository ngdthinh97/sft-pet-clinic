package tng.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import tng.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
