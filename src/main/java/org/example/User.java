package org.example;



import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Date;

@Entity
@Table(name="user")
class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer id;

    @Embedded
    public UserAddress address;

    public User( UserAddress address, Date createdDate) {
        this.address = address;
        this.createdDate = createdDate;
    }

    @Column(name="created_date")
    public Date createdDate;

    public User() {

    }
}
