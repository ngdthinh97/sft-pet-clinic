package tng.springframework.sfgpetclinic.bootstrap;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.model.Pet;
import tng.springframework.sfgpetclinic.model.PetType;
import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.services.OwnerService;
import tng.springframework.sfgpetclinic.services.PetService;
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
		owner1.setAddress("123 brickerel");
		owner1.setCity("Tp.HCM");
		owner1.setTelephone("0694664658");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Adame");
		owner2.setLastName("Anderson");
		owner2.setAddress("9A DXH Q9");
		owner2.setCity("Tp.HCM");
		owner2.setTelephone("0649864156");
		
		ownerService.save(owner2);
		
		Pet fionaCat = new Pet();
		fionaCat.setName("Just cat");
		fionaCat.setPetType(savedCatPetType);
		fionaCat.setBirthDate(LocalDate.now());
		fionaCat.setOwner(owner2);
		owner2.getPets().add(fionaCat);
		
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
