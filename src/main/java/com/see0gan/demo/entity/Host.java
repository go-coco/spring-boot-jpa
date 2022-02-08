package com.see0gan.demo.entity;


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
@Table(
        name = "host",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )
)
public class Host {

    @Id
    @SequenceGenerator(
            name = "host_sequence",
            sequenceName = "host_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "host_sequence"
    )
    private Long hostId;
    private String name;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    private String phone;

    // TODO : A host could have multiple space

//   @JsonBackReference
//   @OneToMany(
//          mappedBy = "host"
//       )
//    private List<Space> space;
//
//    public void addSpace(Space s){
//       if(space==null)
//          space = new ArrayList<>();
//       space.add(s);
//    }
}
