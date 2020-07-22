package tng.springframework.sfgpetclinic.bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.model.PetType;
import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.services.OwnerService;
import tng.springframework.sfgpetclinic.services.PetTypeService;
import tng.springframework.sfgpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		PetType dog = new PetType();
		dog.setName("Eevee");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Leafeon");
		PetType savedCatPetType = petTypeService.save(cat);
		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Thinh");
		owner1.setLastName("Nguyen");
		
		ownerService.save(owner1);
		
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Adame");
		owner2.setLastName("Anderson");
		
		ownerService.save(owner2);
		
		
		System.out.println("Loading owner");
		
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Kuro");
		vet2.setLastName("youkai");
		vetService.save(vet2);
		
		System.out.println("Loading vet");

	}
}
