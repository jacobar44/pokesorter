package com.sorter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sorter.models.PokemonResponse;
import com.sorter.service.PokemonService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("Pokemon")
public class PokemonController {
	

	@Autowired
	private PokemonService pokemonService;
	
	@Override
	public String toString() {
		return "PokemonController [pokemonService=" + pokemonService + "]";
	}


	public PokemonService getPokemonService() {
		return pokemonService;
	}


	public void setPokemonService(PokemonService pokemonService) {
		this.pokemonService = pokemonService;
	}


	public PokemonController(PokemonService pokemonService) {
		super();
		this.pokemonService = pokemonService;
	}
	
	


	
	
	@CrossOrigin()
	@GetMapping("/getall")
	public Mono<PokemonResponse> getAll(){
		return pokemonService.getPokemonSortedByName();
	}
	

}
