package com.see0gan.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpaceOpeningHour {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long timeId;
    private LocalTime openingTime;
    private LocalTime closeTime;
    private LocalDate holiday;     // TODO : able to choose multiple date

 @JsonBackReference
//    @JsonManagedReference
    @OneToOne(

            cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
            ,mappedBy = "openingHour"
    )
//    @JoinColumn(
//            name = "space_id",
//            referencedColumnName = "spaceId"
//    )
    private Space space;
}
