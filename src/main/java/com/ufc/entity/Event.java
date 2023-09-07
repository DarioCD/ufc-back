package com.ufc.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@Column
	private Date fightDate;

	@Column
	private String place;

	@Column
	private String information;

	@OneToMany(mappedBy = "event")
	private List<Fight> fights;

	public Event() {
	}

	public Event(Long id, String title, Date fightDate, String place, String information, List<Fight> fights) {
		this.id = id;
		this.title = title;
		this.fightDate = fightDate;
		this.place = place;
		this.information = information;
		this.fights = fights;
	}

	public Event(String title, Date fightDate, String place, String information, List<Fight> fights) {
		this.title = title;
		this.fightDate = fightDate;
		this.place = place;
		this.information = information;
		this.fights = fights;
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

	public Date getFightDate() {
		return fightDate;
	}

	public void setFightDate(Date fightDate) {
		this.fightDate = fightDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public List<Fight> getFights() {
		return fights;
	}

	public void setFights(List<Fight> fights) {
		this.fights = fights;
	}

}
