package tng.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tng.springframework.sfgpetclinic.model.Owner;


class OwnerServiceMapTest {
	
	OwnerServiceMap ownerServicemap;
	final Long ownerId = 1L;
	final String lastName = "Nguyen";

	@BeforeEach
	void setUp() throws Exception {
		ownerServicemap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		
		ownerServicemap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testOwnerServiceMap() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerServicemap.findAll();
		
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testSaveOwner() {
		Owner owner2 = ownerServicemap.save(Owner.builder().id(2L).build());
		
		ownerServicemap.save(owner2);
		
		assertEquals(2 , ownerServicemap.findAll().size());
	}

	@Test
	void testFindByIdLong() {
		Owner ownerSet = ownerServicemap.findById(ownerId);
		
		assertEquals(1, ownerSet.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServicemap.deleteById(ownerId);
		
		assertEquals(0 , ownerServicemap.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerServicemap.delete(ownerServicemap.findById(ownerId));
		
		assertEquals(0 , ownerServicemap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner ownerNg = ownerServicemap.findByLastName(lastName);
		
		assertEquals(ownerId , ownerNg.getId()); 
	}

}
