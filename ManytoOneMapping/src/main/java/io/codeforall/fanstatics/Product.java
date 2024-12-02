package io.codeforall.fanstatics;

import javax.persistence.*;
import java.nio.file.Path;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;

    @ManyToOne
    private Category category; // for bidirectionality

    public void setCategory(Category category) {
        this.category = category;

    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }
}