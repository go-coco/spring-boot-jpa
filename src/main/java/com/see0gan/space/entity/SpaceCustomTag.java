package com.see0gan.space.entity;

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
public class SpaceCustomTag{

	@Id
	@GeneratedValue
	private Long tagId;
    private String tag1;
    private String tag2;
    private String tag3;

    
    @OneToOne
    @JoinColumn(name = "SPACE_ID", referencedColumnName = "spaceId")  
    @JsonBackReference
    private Space spaceId;

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
