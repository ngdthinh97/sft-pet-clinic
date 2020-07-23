package tng.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import tng.springframework.sfgpetclinic.model.Pet;
import tng.springframework.sfgpetclinic.services.CrudService;
import tng.springframework.sfgpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {
		// TODO Auto-generated method stub
		return super.fildAll();
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	
	
}
