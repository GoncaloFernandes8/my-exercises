package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String username;
    @ManyToMany(
            // fetch all security groups when fetching a user
            fetch = FetchType.EAGER
    )
    private List<SecurityGroup> sgroups;

    public void setName(String username) {
        this.username = username;
    }

    public List<SecurityGroup> getSecurityGroups() {
        return sgroups;
    }
    public void setSecurityGroups(List<SecurityGroup> sgroups) {
        this.sgroups = sgroups;
    }


    // utility methods to update both sides of the relationship
}
