package com.example.facility.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
@Data
@Entity
@Table(name = "facilities")
public class Facility implements Serializable {

@Id
@Column(name = "facility_id")
    private int id;
@Column(name = "facility_name")
    private String name;

    private String description;
}
