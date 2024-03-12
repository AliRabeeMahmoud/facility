package com.example.facility.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "bookings")
public class Booking implements Serializable {
//    tenant_id INT references tenants(tenant_id),
//    ts_id BIGINT references time_slots(ts_id),
//    facility_id int references facilities(facility_id),
//    booking_date DATE,
//    is_cancelled BOOL
    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private BigInteger id;
    @Column(name = "booking_date")
    private Date bookingDate;
    @Column(name = "is_cancelled")
    private boolean isCancelled;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
    @OneToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "start_hour", columnDefinition = "TIME")
    private LocalTime startHour;
    @Column(name = "end_hour", columnDefinition = "TIME")
    private LocalTime endHour;
}
