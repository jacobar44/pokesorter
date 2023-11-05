package com.sorter.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sorter.dao.PokemonDao;
import com.sorter.models.Pokemon;
import com.sorter.models.PokemonResponse;

import reactor.core.publisher.Mono;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonDao pokemonDao;
	public PokemonService(PokemonDao pokemonDao) {
		super();
		this.pokemonDao = pokemonDao;
	}

	@Override
	public String toString() {
		return "PokemonService [pokemonDao=" + pokemonDao + "]";
	}

	public PokemonDao getPokemonDao() {
		return pokemonDao;
	}

	public void setPokemonDao(PokemonDao pokemonDao) {
		this.pokemonDao = pokemonDao;
	}


	
	public Mono<PokemonResponse> getPokemonSortedByName(){
		return pokemonDao.getPokemonLinks().flatMap(poke->{
			poke.setResults(poke.getResults().stream().sorted((x,y)->x.getName().compareTo(y.getName())).collect(Collectors.toList()));
			return Mono.just(poke);
		});
	}
	
}
