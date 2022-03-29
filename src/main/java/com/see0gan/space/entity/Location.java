package com.see0gan.space.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	private String address; // for map api
	private String city; // for search
	private String street;
	private String zipcode;
	
	@OneToOne
	@JoinColumn(name = "SPACE_ID", referencedColumnName = "spaceId")
	@JsonBackReference
	@MapsId
	private Space spaceId;
    
	
	
    
}
