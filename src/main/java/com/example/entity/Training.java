package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private Integer idTtraining;

    @Column(name = "name")
    private String name;

    public Training() {
    }

    public Training(String name) {
        this.name = name;
    }

    public Integer getIdTtraining() {
        return idTtraining;
    }

    public void setIdTtraining(Integer idTtraining) {
        this.idTtraining = idTtraining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Training{" +
                "idTtraining=" + idTtraining +
                ", name='" + name + '\'' +
                '}';
    }
}
