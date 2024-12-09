package io.codeforall.fanstatics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="BoatSingleTable")
@DiscriminatorValue("boat")
class Boat extends Vehicle {
    private Integer engines;
}
