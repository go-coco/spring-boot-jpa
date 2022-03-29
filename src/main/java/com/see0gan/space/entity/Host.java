package com.see0gan.space.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Host implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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

   @JsonManagedReference
    @OneToMany(
          mappedBy = "host",
          cascade = CascadeType.MERGE
       )
    private Set<Space> space;

    public Set<Space> getSpace(){
    	return this.space;
    }
    
    public void addSpace(Space s){
       if(space==null)
          space = new HashSet<>();
       space.add(s);
    }
}
