package com.see0gan.space.dto;

import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Location;
import com.see0gan.space.entity.RefundPolicy;
import com.see0gan.space.entity.SpaceCustomTag;
import com.see0gan.space.entity.SpaceFacility;
import com.see0gan.space.entity.SpaceOpenTime;
import com.see0gan.space.entity.SpaceType;

import lombok.Data;

@Data
//@JsonIgnoreProperties
public class SpaceForm extends SpaceDto{
//	
//	private Long spaceId;
//	private String spaceName;        
//    private SpaceType type;
//    private String intro1;
//    private String intro2;
//    private Integer capacity;
//    private String img1;
//    private String img2;
//    private Integer price;
//   @JsonBackReference
    private Host host;
    private Location address;
    private SpaceFacility facility;
    private SpaceCustomTag tags;
    private SpaceOpenTime openTime;
    
   
//    private boolean printer;
//
//    private boolean airCon;
//
//    private boolean parking;
//
//    private boolean freeWifi;
  
 
	
}
