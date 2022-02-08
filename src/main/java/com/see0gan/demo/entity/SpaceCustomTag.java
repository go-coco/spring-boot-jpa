package com.see0gan.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tag")
public class SpaceCustomTag{

    @Id
    @SequenceGenerator(
            name="tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    private Long tagId;

//    @JsonManagedReference
  @JsonBackReference
    @OneToOne(
            mappedBy = "tag"//,
       //     cascade = CascadeType.ALL
        //   , fetch = FetchType.LAZY
        //    , optional = false
    )
//
//    @JoinColumn(
//            name = "space_id",
//            referencedColumnName = "spaceId"
//    )
    private Space space;
    private String tag1;
    private String tag2;
    private String tag3;


}

// tag 를 Embeddable 로 만들려다가 검색에 사용할 수 있으니 따로 테이블을 만들기로 함
// TODO: performance enhancement -> study persistence context & life cycle (?, managed, detached, removed)
// TODO : add hibernate valid annotations
// TODO : also look at EntityManager class

//@Embeddable
//@AttributeOverrides({
//        @AttributeOverride(
//                name = "tag1",
//                column = @Column(name = "tag1")
//        ),
//        @AttributeOverride(
//                name = "tag2",
//                column = @Column(name = "tag2")
//        ),
//        @AttributeOverride(
//                name = "tag3",
//                column = @Column(name = "tag3")
//        )
//})
//public class SpaceTag { .... }
