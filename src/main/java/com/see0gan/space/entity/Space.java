package com.see0gan.space.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.see0gan.booking.entity.Booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SPACE")
@Where(clause = "deleted = false")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Space {

    @Id
    @SequenceGenerator(
            name = "space_sequence",
            sequenceName = "space_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "space_sequence"
    )
    private Long spaceId;
   
    
    private String spaceName;    
    
    private SpaceType type;
    
    private String intro1;
    
    private String intro2;
    
    private Integer capacity;
    
    // TODO : file upload
    private String img1;
    
    private String img2;
    
    private LocalDate regDate;
    
    private Integer price;
    
    @Embedded
    private RefundPolicy refund;
    
    private boolean deleted;

    
    
    @ManyToOne(
    		fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
          ,  optional = false
    )
    @JoinColumn(
            name = "host_id",
            referencedColumnName = "hostId",
            nullable=false
    )
    @JsonBackReference
    private Host host;
    
  
    @OneToOne( fetch = FetchType.LAZY, mappedBy = "spaceId")
    private Location address;
    
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "spaceId")
    private SpaceCustomTag tag;
    
    
    @OneToOne(
    		fetch = FetchType.LAZY, mappedBy = "space")
    private SpaceFacility facility;
  
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "space")
    private SpaceOpenTime openingHour;


    @OneToMany(
    		fetch = FetchType.LAZY,	mappedBy = "space"
    		)    
    @JsonManagedReference(value = "space-closure")
    private Set<TemporaryClosure> closures;
    
    @OneToMany(mappedBy = "space")
    @JsonManagedReference(value = "space-booking")
    private Set<Booking> booking;

}
