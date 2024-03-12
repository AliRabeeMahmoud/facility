package com.example.facility.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalTime;


import java.util.Date;

@AllArgsConstructor
@Data

public class BookingDto {
    private int facilityId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date bookingDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    private BigInteger tenantId;
    @Column(name = "start_hour", columnDefinition = "TIME")
    private LocalTime startHour;
    @Column(name = "end_hour", columnDefinition = "TIME")
    private LocalTime endHour;



}
