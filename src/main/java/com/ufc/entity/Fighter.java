package com.ufc.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private Integer drawFights;

	@Column
	private String record;

	@Column
	private Integer rankingNumber;

	@JsonIgnore
	@OneToMany(mappedBy = "fighter")
	private Set<Fight> fights = new HashSet<Fight>();

	@ManyToOne
	@JoinColumn(name = "ranking_id")
	private Ranking ranking;

	public Fighter() {

	}

	public Fighter(Long id, String name, String surname, Date dateOfBirth, String nationality, Float weight,
			Float height, Integer winFights, Integer lostFights, Integer drawFights, String record,
			Integer rankingNumber, Set<Fight> fights, Ranking ranking) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.weight = weight;
		this.height = height;
		this.winFights = winFights;
		this.lostFights = lostFights;
		this.drawFights = drawFights;
		this.record = record;
		this.rankingNumber = rankingNumber;
		this.fights = fights;
		this.ranking = ranking;
	}

	public Fighter(String name, String surname, Date dateOfBirth, String nationality, Float weight, Float height,
			Integer winFights, Integer lostFights, Integer drawFights, String record, Integer rankingNumber,
			Set<Fight> fights, Ranking ranking) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.weight = weight;
		this.height = height;
		this.winFights = winFights;
		this.lostFights = lostFights;
		this.drawFights = drawFights;
		this.record = record;
		this.rankingNumber = rankingNumber;
		this.fights = fights;
		this.ranking = ranking;
	}

	public Integer getDrawFights() {
		return drawFights;
	}

	public void setDrawFights(Integer drawFights) {
		this.drawFights = drawFights;
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

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
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

	public Integer getRankingNumber() {
		return rankingNumber;
	}

	public void setRankingNumber(Integer rankingNumber) {
		this.rankingNumber = rankingNumber;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Set<Fight> getFights() {
		return fights;
	}

	public void setFights(Set<Fight> fights) {
		this.fights = fights;
	}

	public void updateRecord() {
		this.record = winFights + " - " + lostFights + " - " + drawFights;
	}

}
