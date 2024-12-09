package io.codeforall.fanstatics;

import javax.persistence.*;

@Entity

@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String make;
    private String model;

    @OneToOne
    private Owner owner; // for bidirectionality

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Object getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }
}

