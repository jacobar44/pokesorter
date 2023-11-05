package com.sorter.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class PokemonResponse {
	
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<Pokemon> getResults() {
		return results;
	}
	public void setResults(List<Pokemon> results) {
		this.results = results;
	}
	@JsonProperty("next")
	private String next;
	@JsonProperty("count")
	private int count;
	@JsonProperty("previous")
	private String previous;
	@JsonProperty("results")
	private List<Pokemon> results;
}