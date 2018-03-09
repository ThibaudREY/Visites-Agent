package com.visites.agent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "agent")
@JsonIgnoreProperties
public class    Agent implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "telephone")
    private String telephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name.trim();
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name.trim();
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTelephone() {
        return telephone.trim();
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "{" +
                "\"first_name\": \"" + this.getFirst_name() + "\"," +
                "\"last_name\": \"" + this.getLast_name() + "\"," +
                "\"telephone\": \"" + this.getTelephone() + "\"" +
            "}";
    }
}
