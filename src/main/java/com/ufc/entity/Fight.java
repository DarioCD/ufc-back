package com.ufc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fight")
public class Fight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String result;

	@Column
	private String rival;

	@Column
	private String method;

	@Column
	private Integer round;

	@Column
	private String time;

	@Column
	private String company;

	@ManyToOne
	@JoinColumn(name = "fighter_id")
	private Fighter fighter;

	public Fight() {
	}

	public Fight(Long id, String result, String rival, String method, Integer round, String time, String company,
			Fighter fighter) {
		this.id = id;
		this.result = result;
		this.rival = rival;
		this.method = method;
		this.round = round;
		this.time = time;
		this.company = company;
		this.fighter = fighter;
	}

	public Fight(String result, String rival, String method, Integer round, String time, String company,
			Fighter fighter) {
		this.result = result;
		this.rival = rival;
		this.method = method;
		this.round = round;
		this.time = time;
		this.company = company;
		this.fighter = fighter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRival() {
		return rival;
	}

	public void setRival(String rival) {
		this.rival = rival;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Fighter getFighter() {
		return fighter;
	}

	public void setFighter(Fighter fighter) {
		this.fighter = fighter;
	}

}
