package tng.springframework.sfgpetclinic.services.map;

import java.util.List;
import java.util.Set;  


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.model.Pet;
import tng.springframework.sfgpetclinic.services.OwnerService;
import tng.springframework.sfgpetclinic.services.PetService;
import tng.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner , Long> implements OwnerService{
	
	private final PetService petService;
	private final PetTypeService petTypeService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}
	
	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet type is required");
					}
					if(pet.getId() == null) {
						Pet savePet = petService.save(pet);
						pet.setId(savePet.getId());
					}
				});
			}
			return super.save(object);
		}
		else {
			return null;
		}
	}
	
	
	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
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
	//---------------------------------------------

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return this.findAll()
				.stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	




	 
}
