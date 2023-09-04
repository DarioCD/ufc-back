package com.ufc.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ranking")
public class Ranking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String weight;

	@JsonIgnore
	@OneToMany(mappedBy = "ranking")
	private Set<Fighter> fighters = new HashSet<Fighter>();

	public Ranking() {
	}

	public Ranking(Long id, String name, String weight, Set<Fighter> fighters) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.fighters = fighters;
	}

	public Ranking(String name, String weight, Set<Fighter> fighters) {
		this.name = name;
		this.weight = weight;
		this.fighters = fighters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Set<Fighter> getFighters() {
		return fighters;
	}

	public void setFighters(Set<Fighter> fighters) {
		this.fighters = fighters;
	}

}
