package com.example.case2bugrayus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Address {
    int doorNumber;
    int apartmentNumber;
    String name;
    @JsonIgnore
    @OneToOne
    Country country;
    @JsonIgnore
    @OneToOne
    City city;
    @JsonIgnore
    @OneToOne
    District district;
    @JsonIgnore
    @OneToOne
    Quarter quarter;
    @JsonIgnore
    @OneToOne
    Street street;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return id != null && Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
