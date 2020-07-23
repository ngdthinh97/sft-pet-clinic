package tng.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
}
