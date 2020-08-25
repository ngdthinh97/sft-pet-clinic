package tng.springframework.sfgpetclinic.services;


import java.util.List;

import tng.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
