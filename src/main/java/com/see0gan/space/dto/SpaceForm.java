package com.see0gan.space.dto;

import com.see0gan.space.entity.Host;
import com.see0gan.space.entity.Location;

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
  //  private SpaceFacility facility;
    
 
//    private boolean printer;
//
//    private boolean airCon;
//
//    private boolean parking;
//
//    private boolean freeWifi;
  
 
	
}
