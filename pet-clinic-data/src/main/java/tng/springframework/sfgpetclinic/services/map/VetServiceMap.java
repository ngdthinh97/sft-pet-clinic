package tng.springframework.sfgpetclinic.services.map;

import java.util.Set;

import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.services.CrudService;
import tng.springframework.sfgpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	@Override
	Set<Vet> fildAll() {
		// TODO Auto-generated method stub
		return super.fildAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	Vet save(Long id, Vet object) {
		// TODO Auto-generated method stub
		return super.save(id, object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	//
	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
