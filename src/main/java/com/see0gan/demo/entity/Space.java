package com.see0gan.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table
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

    @ManyToOne(
            cascade = CascadeType.ALL
//          ,  fetch = FetchType.LAZY
          ,  optional = false
    )
    @JoinColumn(
            name = "host_id",
            referencedColumnName = "hostId"
    )
    private Host host;

    private SpaceType type;
    private String intro1;
    private String intro2;
    private Integer capacity;
    // TODO : file upload
    private String img1;
    private String img2;
    private String address1; // full address
    private String address2; // city
    private LocalDate regDate;
    private Integer price;

    @OneToOne(
            cascade = CascadeType.ALL
//           , fetch = FetchType.LAZY
            //      , orphanRemoval = true
    )
    @JoinColumn(
            name = "tag_id",
            referencedColumnName = "tagId"
    )
    private SpaceCustomTag tag;

    @OneToOne(
            cascade = CascadeType.ALL
//              ,fetch = FetchType.LAZY
       //     ,orphanRemoval = true
    )
    @JoinColumn(
            name = "facility_id",
            referencedColumnName = "facilityId"
    )
    private SpaceFacility facility;

    @Embedded
    private RefundPolicy refund;

  @OneToOne(
            cascade = CascadeType.ALL
       //     , mappedBy = "space"
//            ,fetch = FetchType.LAZY
           // ,orphanRemoval = true
    )
    @JoinColumn(
            name = "time_id",
            referencedColumnName = "timeId"
    )
    private SpaceOpeningHour openingHour;



}
