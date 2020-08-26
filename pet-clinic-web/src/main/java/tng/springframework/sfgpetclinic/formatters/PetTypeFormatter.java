package tng.springframework.sfgpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import tng.springframework.sfgpetclinic.model.PetType;
import tng.springframework.sfgpetclinic.services.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType>{
	
    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

	@Override
	public String print(PetType petType, Locale locale) {
		// TODO Auto-generated method stub
		return petType.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
	}
    
}
