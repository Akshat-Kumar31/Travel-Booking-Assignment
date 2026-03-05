package com.akshat.travelbooking.controller;

import com.akshat.travelbooking.dto.BookingRequestDTO;
import com.akshat.travelbooking.dto.BookingResponseDTO;
import com.akshat.travelbooking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create booking
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO requestDTO) {
        return bookingService.createBooking(requestDTO);
    }

    // Get booking status
    @GetMapping("/{bookingId}")
    public BookingResponseDTO getBookingStatus(@PathVariable Long bookingId) {
        return bookingService.getBookingStatus(bookingId);
    }

    //Get all bookings
    @GetMapping
    public List<BookingResponseDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }
}