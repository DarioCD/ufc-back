package com.ufc.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fighter")
public class Fighter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private Date dateOfBirth;

	@Column
	private String nationality;

	@Column
	private Float weight;

	@Column
	private Float height;

	@Column
	private Integer winFights;

	@Column
	private Integer lostFights;

	@Column
	private String record;

	public Fighter() {

	}

	public Fighter(Long id, String name, String surname, Date dateOfBirth, String nationality, Float weight,
			Integer winFights, Integer lostFights, String record, Float height) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.weight = weight;
		this.winFights = winFights;
		this.lostFights = lostFights;
		this.record = record;
		this.height = height;
	}

	public Fighter(String name, String surname, Date dateOfBirth, String nationality, Float weight, Integer winFights,
			Integer lostFights, String record, Float height) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.weight = weight;
		this.winFights = winFights;
		this.lostFights = lostFights;
		this.record = record;
		this.height = height;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getWinFights() {
		return winFights;
	}

	public void setWinFights(Integer winFights) {
		this.winFights = winFights;
	}

	public Integer getLostFights() {
		return lostFights;
	}

	public void setLostFights(Integer lostFights) {
		this.lostFights = lostFights;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

}
