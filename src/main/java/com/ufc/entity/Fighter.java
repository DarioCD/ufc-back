package com.ufc.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private String nickname;

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
	private Integer age;

	@Column
	private Float reach;

	@Column
	private Float legReach;

	@Column
	private Integer winFights;

	@Column
	private Integer lostFights;

	@Column
	private Integer drawFights;

	@Column
	private String record;

	@Column
	private String gym;

	@Column
	private String fightStyle;

	@Column
	private Integer rankingNumber;
	
	@Column
	private Integer rankingp4pNumber;

	@Column
	private String fighterPhoto;

	@Column
	private String fighterFullPhoto;

	@JsonIgnoreProperties("fighters")
	@ManyToMany(mappedBy = "fighters")
	private Set<Fight> fights = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "ranking_id")
	private Ranking ranking;

	@ManyToOne
	@JoinColumn(name = "rankingp4p_id")
	private RankingP4P rankingP4P;

	public Fighter() {

	}

	public Fighter(Long id, String name, String nickname, String surname, Date dateOfBirth, String nationality,
			Float weight, Float height, Integer age, Float reach, Float legReach, Integer winFights, Integer lostFights,
			Integer drawFights, String record, String gym, String fightStyle, Integer rankingNumber, Integer rankingp4pNumber, Set<Fight> fights,
			Ranking ranking, RankingP4P rankingP4P, String fighterPhoto, String fighterFullPhoto) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.reach = reach;
		this.legReach = legReach;
		this.winFights = winFights;
		this.lostFights = lostFights;
		this.drawFights = drawFights;
		this.record = record;
		this.gym = gym;
		this.fightStyle = fightStyle;
		this.rankingNumber = rankingNumber;
		this.rankingp4pNumber = rankingp4pNumber;
		this.fights = fights;
		this.ranking = ranking;
		this.rankingP4P = rankingP4P;
		this.fighterPhoto = fighterPhoto;
		this.fighterFullPhoto = fighterFullPhoto;
	}

	public Fighter(String name, String nickname, String surname, Date dateOfBirth, String nationality, Float weight,
			Float height, Integer age, Float reach, Float legReach, Integer winFights, Integer lostFights,
			Integer drawFights, String record, String gym, String fightStyle, Integer rankingNumber,Integer rankingp4pNumber, Set<Fight> fights,
			Ranking ranking, RankingP4P rankingP4P, String fighterPhoto, String fighterFullPhoto) {
		this.name = name;
		this.nickname = nickname;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.reach = reach;
		this.legReach = legReach;
		this.winFights = winFights;
		this.lostFights = lostFights;
		this.drawFights = drawFights;
		this.record = record;
		this.gym = gym;
		this.fightStyle = fightStyle;
		this.rankingNumber = rankingNumber;
		this.rankingp4pNumber = rankingp4pNumber;
		this.fights = fights;
		this.ranking = ranking;
		this.rankingP4P = rankingP4P;
		this.fighterPhoto = fighterPhoto;
		this.fighterFullPhoto = fighterFullPhoto;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getReach() {
		return reach;
	}

	public void setReach(Float reach) {
		this.reach = reach;
	}

	public Float getLegReach() {
		return legReach;
	}

	public void setLegReach(Float legReach) {
		this.legReach = legReach;
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

	public Integer getDrawFights() {
		return drawFights;
	}

	public void setDrawFights(Integer drawFights) {
		this.drawFights = drawFights;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
	}

	public String getFightStyle() {
		return fightStyle;
	}

	public void setFightStyle(String fightStyle) {
		this.fightStyle = fightStyle;
	}

	public Integer getRankingNumber() {
		return rankingNumber;
	}

	public void setRankingNumber(Integer rankingNumber) {
		this.rankingNumber = rankingNumber;
	}

	public Integer getRankingp4pNumber() {
		return rankingp4pNumber;
	}

	public void setRankingp4pNumber(Integer rankingp4pNumber) {
		this.rankingp4pNumber = rankingp4pNumber;
	}

	public Set<Fight> getFights() {
		return fights;
	}

	public void setFights(Set<Fight> fights) {
		this.fights = fights;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public RankingP4P getRankingP4P() {
		return rankingP4P;
	}

	public void setRankingP4P(RankingP4P rankingP4P) {
		this.rankingP4P = rankingP4P;
	}

	public void updateRecord() {
		this.record = winFights + " - " + lostFights + " - " + drawFights;
	}

	public String getFighterPhoto() {
		return fighterPhoto;
	}

	public void setFighterPhoto(String fighterPhoto) {
		this.fighterPhoto = fighterPhoto;
	}

	public String getFighterFullPhoto() {
		return fighterFullPhoto;
	}

	public void setFighterFullPhoto(String fighterFullPhoto) {
		this.fighterFullPhoto = fighterFullPhoto;
	}

}
