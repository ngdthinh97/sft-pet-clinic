package tng.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tng.springframework.sfgpetclinic.model.Owner;
import tng.springframework.sfgpetclinic.repositories.OwnerRepository;
import tng.springframework.sfgpetclinic.repositories.PetRepository;
import tng.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	private final String Last_name = "Nguyen";
	private final Long id = 1L;
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(1L).lastName(Last_name).build();
		
	}

	@Test
	void testOwnerSDJpaService() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().id(1L).build());
		returnOwnerSet.add(Owner.builder().id(2L).build());
		
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
		
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = service.findById(id);
		
		assertNotNull(owner);
	}

	@Test
	void testSave() {
		Owner thinh = Owner.builder().id(2L).build();
		
		thinh.setTelephone("0967937403");
		
		ownerRepository.save(thinh);
		
		assertEquals("0967937403", thinh.getTelephone());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(id);
		
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner thinh = service.findByLastName(Last_name);
		
		assertEquals(Last_name, thinh.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}

}
