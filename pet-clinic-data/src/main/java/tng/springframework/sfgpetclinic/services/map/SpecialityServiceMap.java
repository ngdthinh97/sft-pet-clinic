package tng.springframework.sfgpetclinic.services.map;

import java.util.Set;

import tng.springframework.sfgpetclinic.model.Speciality;
import tng.springframework.sfgpetclinic.services.SpecialitiesService;

public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService{

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.fildAll();
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	
}
