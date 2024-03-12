package com.example.facility.controller;

import com.example.facility.dto.BookingDto;
import com.example.facility.model.Booking;
import com.example.facility.model.Facility;
import com.example.facility.model.Tenant;
import com.example.facility.repository.BookingRepo;
import com.example.facility.repository.FacilityRepo;
import com.example.facility.repository.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private FacilityRepo facilityRepo;

    @PostMapping("/tenant/register")
    public String register(@RequestBody Tenant tenant){
        tenantRepo.save(tenant);
        return "success";
    }
    @GetMapping("/admin/tenants")
    public List<Tenant> getTenants(){
       return tenantRepo.findAll();
    }
    @PostMapping("/tenant/booking")
    public String book(@RequestBody BookingDto bookingDto){
        bookingRepo.save(mapToBooking(bookingDto));
        return "success";
    }
    @GetMapping("/admin/bookings")
    public List<Booking> getBookings(){
        return bookingRepo.findAll();
    }
    public Booking mapToBooking(BookingDto bo){
        Booking booking = new Booking();
        Optional<Facility> facility = facilityRepo.findById(bo.getFacilityId());
        Optional<Tenant> tenant = tenantRepo.findById(bo.getTenantId());
        booking.setStartDate(bo.getStartDate());
        booking.setCancelled(false);
        booking.setStartHour(bo.getStartHour());
        booking.setEndHour(bo.getEndHour());
        booking.setBookingDate(bo.getBookingDate());
        return booking;

    }
    @PostMapping("/admin/facility")
    public String createFacility(@RequestBody Facility facility){
        facilityRepo.save(facility);

        return "success";
    }
    @GetMapping("/tenant/facilities")
    public List<Facility> getFacilities(){
        return facilityRepo.findAll();
    }


}
