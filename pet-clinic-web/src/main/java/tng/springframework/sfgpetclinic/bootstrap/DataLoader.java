package tng.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.model.Person;
import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.services.OwnerService;
import tng.springframework.sfgpetclinic.services.VetService;
import tng.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import tng.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	
	public DataLoader() {
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Thinh");
		owner1.setLastName("Nguyen");
		
		ownerService.save(owner1);
		
		
		Owner owner2 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Thinh2");
		owner1.setLastName("Nguyen2");
		
		ownerService.save(owner2);
		
		
		System.out.println("Loading owner");
		
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Sam2");
		vet2.setLastName("Axe2");
		vetService.save(vet2);
		
		System.out.println("Loading vet");
	}
}
