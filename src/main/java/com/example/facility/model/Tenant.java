package com.example.facility.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name="tenants")
public class Tenant implements Serializable {


@Column(name = "tenant_id")
@Id
@GeneratedValue
    private BigInteger id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String phone;
    private String email;
    private String nationality;
    private String gender;
    @Column(name = "birth_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    @Column(name = "tenant_password")
    private String password;
    @OneToMany
    @JoinColumn(name = "tenant_id")
    private List<Booking> bookings;

}
