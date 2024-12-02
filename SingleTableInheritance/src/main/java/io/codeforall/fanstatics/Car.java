package io.codeforall.fanstatics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="CarSingleTable")
@DiscriminatorValue("car")
class Car extends Vehicle {
    private Integer gears;
}
