package tng.springframework.sfgpetclinic.services.map;

import java.util.Set;

import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.services.CrudService;
import tng.springframework.sfgpetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner , Long> implements OwnerService{

	@Override
	public Set<Owner> fildAll() {
		// TODO Auto-generated method stub
		return super.fildAll();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Owner save(Long id, Owner object) {
		// TODO Auto-generated method stub
		return super.save(id, object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
