package tng.springframework.sfgpetclinic.bootstrap;
import java.time.LocalDate; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.model.Pet;
import tng.springframework.sfgpetclinic.model.PetType;
import tng.springframework.sfgpetclinic.model.Speciality;
import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.model.Visit;
import tng.springframework.sfgpetclinic.services.OwnerService;
import tng.springframework.sfgpetclinic.services.PetService;
import tng.springframework.sfgpetclinic.services.PetTypeService;
import tng.springframework.sfgpetclinic.services.SpecialityService;
import tng.springframework.sfgpetclinic.services.SpecialityService;
import tng.springframework.sfgpetclinic.services.VetService;
import tng.springframework.sfgpetclinic.services.VisitService;


@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService,SpecialityService specialityService, 
				VisitService visitService) {
		
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Eevee");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Leafeon");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality saveRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality saveSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality saveDentistry = specialityService.save(dentistry);
		
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
		
		Pet fionaCat = new Pet();
		fionaCat.setName("Just cat");
		fionaCat.setPetType(savedCatPetType);
		fionaCat.setBirthDate(LocalDate.now());
		owner2.getPets().add(fionaCat);
		fionaCat.setOwner(owner2);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Black neko around");
		
		catVisit.setPet(fionaCat);
		visitService.save(catVisit);
		
		System.out.println("cat this is id fionaCat :"  + fionaCat.getId());
		
		System.out.println("Loading owner");
		
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(saveDentistry);
		vetService.save(vet1);
		
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Kuro");
		vet2.setLastName("youkai");
		vet2.getSpecialities().add(saveRadiology);
		vetService.save(vet2);
		
		System.out.println("Loading vet");
	}
}
