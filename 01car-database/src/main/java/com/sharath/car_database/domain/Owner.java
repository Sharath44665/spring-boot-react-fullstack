package com.sharath.car_database.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerid;
    private String firstname, lastname;

//    @OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
//    private List<Car> cars;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="car_owner",joinColumns = { @JoinColumn(name="ownerid") },
                                inverseJoinColumns = { @JoinColumn(name="id") })
    private Set<Car> cars = new HashSet<Car>();

    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Owner() {
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
