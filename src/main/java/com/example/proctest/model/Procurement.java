package com.example.proctest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "proc")
public class Procurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String znp;

    @Override
    public String toString() {
        return "Procurement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", znp='" + znp + '\'' +
                '}';
    }
}
