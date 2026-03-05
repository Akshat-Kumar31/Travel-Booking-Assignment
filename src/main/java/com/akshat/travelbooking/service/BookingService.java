package com.akshat.travelbooking.service;



import com.akshat.travelbooking.dto.BookingRequestDTO;
import com.akshat.travelbooking.dto.BookingResponseDTO;
import com.akshat.travelbooking.exception.ResourceNotFoundException;
import com.akshat.travelbooking.model.Booking;
import com.akshat.travelbooking.model.TravelOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {

    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong bookingIdGenerator = new AtomicLong(1);
    private final SearchService searchService;

    public BookingService(SearchService searchService) {
        this.searchService = searchService;
    }


    //Method to create a new booking
    public BookingResponseDTO createBooking(BookingRequestDTO requestDTO) {

        TravelOption option = searchService.getById(requestDTO.getTravelOptionId());

        Booking booking = new Booking();
        booking.setId(bookingIdGenerator.getAndIncrement());
        booking.setTravelOptionId(option.getId());
        booking.setPassengerName(requestDTO.getPassengerName());
        booking.setStatus("PAYMENT PENDING");

        bookings.add(booking);

        return new BookingResponseDTO(
                booking.getId(),
                booking.getTravelOptionId(),
                booking.getPassengerName(),
                booking.getStatus()
        );
    }


    //Method to get booking by booking ID
    public Booking getBookingById(Long bookingId) {
        return bookings.stream()
                .filter(b -> b.getId().equals(bookingId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id: " + bookingId));
    }


    //Method to get booking Status
    public BookingResponseDTO getBookingStatus(Long bookingId) {

        Booking booking = getBookingById(bookingId);

        return new BookingResponseDTO(
                booking.getId(),
                booking.getTravelOptionId(),
                booking.getPassengerName(),
                booking.getStatus()
        );
    }


    //Method to get all bookings
    public List<BookingResponseDTO> getAllBookings() {

        if (bookings.isEmpty()) {
            throw new ResourceNotFoundException("No bookings found");
        }

        return bookings.stream()
                .map(booking -> new BookingResponseDTO(
                        booking.getId(),
                        booking.getTravelOptionId(),
                        booking.getPassengerName(),
                        booking.getStatus()
                ))
                .toList();
    }
}
