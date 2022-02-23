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
public class Street {
    String name;
    @JsonIgnore
    @OneToOne
    Quarter quarter;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Street street = (Street) o;
        return id != null && Objects.equals(id, street.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
