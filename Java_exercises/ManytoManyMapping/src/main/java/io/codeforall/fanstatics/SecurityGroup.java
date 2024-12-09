package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sgroup")
public class SecurityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(
            // mappedBy required for bidirectional association
            mappedBy="sgroups",

            // delay fetching users until they are actually needed
            fetch = FetchType.LAZY
    )



    private List<User> users;

    public void setName(String name) {
        this.name = name;
    }
}
