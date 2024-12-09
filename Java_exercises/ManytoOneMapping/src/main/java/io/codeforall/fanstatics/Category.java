package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            // use Category foreign key on Product table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "category"
    )
    public Set<Product> products;

    // utility method to update both sides of the association
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getId() {
        return id;
    }

    public Iterable<Object> getProducts() {
        return Collections.singleton(products);
    }

    public String getName() {
        return name;
    }
}