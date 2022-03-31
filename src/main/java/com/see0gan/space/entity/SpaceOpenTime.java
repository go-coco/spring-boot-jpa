package com.see0gan.space.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import groovy.transform.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class SpaceOpenTime {

//	@Id
//	@GeneratedValue
	private Long openingId;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String holiday; 

}
