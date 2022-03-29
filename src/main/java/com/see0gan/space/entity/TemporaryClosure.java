package com.see0gan.space.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemporaryClosure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clourseId;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SPACE_ID", referencedColumnName = "spaceId")
	@JsonBackReference(value = "space-closure")
	private Space space;
	
	
	private LocalDate date;
	private LocalTime time;
	private Integer duration;
	
	
	
}
