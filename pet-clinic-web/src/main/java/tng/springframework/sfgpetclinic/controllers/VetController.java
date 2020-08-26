package tng.springframework.sfgpetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tng.springframework.sfgpetclinic.model.Vet;
import tng.springframework.sfgpetclinic.services.VetService;


@Controller
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"/index","/index.html","/vets.html"})
	public String vetList(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
	
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson(){

        return vetService.findAll();
    }
	
}
