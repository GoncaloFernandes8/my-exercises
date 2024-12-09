package io.codeforall.fanstatics;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadets")
public class Cadet {

    @Id
    private Integer id;

    private String name;
    private int age;

    @Embedded
    private Address address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
