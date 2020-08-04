package tng.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import tng.springframework.sfgpetclinic.model.Speciality;
import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.services.CrudService;
import tng.springframework.sfgpetclinic.services.SpecialityService;
import tng.springframework.sfgpetclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		if(object.getSpecialities().size() > 1) {
			object.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null) {
					Speciality saveSpeciality = specialityService.save(speciality);
					speciality.setId(saveSpeciality.getId());
				}
			});
		}
		
		return super.save(object);
	}

	@Override
	public Vet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
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
	
	
	
}
