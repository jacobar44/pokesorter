package com.sorter.dao;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.sorter.models.PokemonResponse;

import reactor.core.publisher.Mono;
@Component
public class PokemonDao {
	
	
	@Override
	public String toString() {
		return "PokemonDao []";
	}

	public PokemonDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mono<PokemonResponse> getPokemonLinks() {
	return	WebClient.builder().baseUrl("https://pokeapi.co/api/v2/pokemon/?limit=1200").build().get().exchangeToMono(res->{
		return res.bodyToMono(new ParameterizedTypeReference<PokemonResponse>() {}).flatMap(
				resp->{
					return Mono.just(resp);
				}
				);
		
	});
			
		
	}
	
	

}
