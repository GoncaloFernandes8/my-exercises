package io.codeforall.fanstatics;

import javax.persistence.*;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;

    @OneToOne(
            // propagate changes on Owner entity to Car entities
            cascade = {CascadeType.ALL},
            // Owner removal will remove Car due to cascade, but this property makes
            // sure we also remove the Car if unlinked from Owner (orphaned)
            orphanRemoval = true,
            // mappedBy is required for bidirectional associations, and it tells hibernate
            // to use the user foreign key on the Car table to define the Owner
            mappedBy = "owner"
    )
    private Car car;

    public void setName(String name) {
        this.name = name;
    }
}