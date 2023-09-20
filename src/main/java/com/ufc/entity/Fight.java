package com.ufc.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fight")
public class Fight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private String result;

	@Column
	private String mehtod;

	@Column
	private String round;

	@Column
	private String time;
	
	@Column
	private String fighter1;

	@Column
	private String fighter2;

	@Column
	private String company;

	@JsonIgnoreProperties("fights")
	@ManyToMany
	@JoinTable(name = "fight_fighter", joinColumns = @JoinColumn(name = "fight_id"), inverseJoinColumns = @JoinColumn(name = "fighter_id"))
	private Set<Fighter> fighters = new HashSet<Fighter>();

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	public Fight() {
	}

	public Fight(String title, String result, String mehtod, String round, String time, String fighter1, String fighter2, String company,
			Set<Fighter> fighters, Event event) {
		this.title = title;
		this.result = result;
		this.mehtod = mehtod;
		this.round = round;
		this.time = time;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.company = company;
		this.fighters = fighters;
		this.event = event;
	}

	public Fight(Long id, String title, String result, String mehtod, String round, String time, String fighter1, String fighter2,String company,
			Set<Fighter> fighters, Event event) {
		this.id = id;
		this.title = title;
		this.result = result;
		this.mehtod = mehtod;
		this.round = round;
		this.time = time;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.company = company;
		this.fighters = fighters;
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Set<Fighter> getFighters() {
		return fighters;
	}

	public void setFighters(Set<Fighter> fighters) {
		this.fighters = fighters;
	}

	public String getFighter1() {
		return fighter1;
	}

	public void setFighter1(String fighter1) {
		this.fighter1 = fighter1;
	}

	public String getFighter2() {
		return fighter2;
	}

	public void setFighter2(String fighter2) {
		this.fighter2 = fighter2;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMehtod() {
		return mehtod;
	}

	public void setMehtod(String mehtod) {
		this.mehtod = mehtod;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
