package com.see0gan.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "tag1",
                column = @Column(name = "tag1")
        ),
        @AttributeOverride(
                name = "tag2",
                column = @Column(name = "tag2")
        ),
        @AttributeOverride(
                name = "tag3",
                column = @Column(name = "tag3")
        )
})
public class RefundPolicy {

    private Integer before30;
    private Integer before7;
    private Integer before1;


}
