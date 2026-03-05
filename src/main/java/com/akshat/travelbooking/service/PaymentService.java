package com.akshat.travelbooking.service;

import com.akshat.travelbooking.dto.PaymentRequestDTO;
import com.akshat.travelbooking.dto.PaymentResponseDTO;
import com.akshat.travelbooking.model.Booking;
import com.akshat.travelbooking.model.Payment;
import com.akshat.travelbooking.model.TravelOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PaymentService {

    private final List<Payment> payments = new ArrayList<>();
    private final AtomicLong paymentIdGenerator = new AtomicLong(1);

    private final BookingService bookingService;
    private final SearchService searchService;

    public PaymentService(BookingService bookingService,
                          SearchService searchService) {
        this.bookingService = bookingService;
        this.searchService = searchService;
    }


    //Method to make payment
    public PaymentResponseDTO makePayment(PaymentRequestDTO requestDTO) {

        //Get Booking
        Booking booking = bookingService.getBookingById(requestDTO.getBookingId());

        //Prevent duplicate payment
        if ("CONFIRMED".equals(booking.getStatus())) {
            throw new IllegalStateException("Booking already confirmed");
        }

        //Get Travel Option linked to booking
        TravelOption option = searchService.getById(booking.getTravelOptionId());

        //Validate payment amount
        if (!requestDTO.getAmount().equals(option.getPrice())) {
            throw new IllegalStateException(
                    "Incorrect payment amount. Expected: " + option.getPrice()
            );
        }

        //Create Payment
        Payment payment = new Payment();
        payment.setId(paymentIdGenerator.getAndIncrement());
        payment.setBookingId(requestDTO.getBookingId());
        payment.setAmount(requestDTO.getAmount());

        //Dummy card validation
        if (requestDTO.getCardNumber().matches("\\d{16}")) {
            payment.setStatus("SUCCESS");
            booking.setStatus("CONFIRMED");
        } else {
            payment.setStatus("FAILED");
        }

        payments.add(payment);

        //Return PaymentResponseDTO with masked card number
        return new PaymentResponseDTO(
                payment.getId(),
                payment.getBookingId(),
                payment.getAmount(),
                payment.getStatus(),
                maskCardNumber(requestDTO.getCardNumber())
        );
    }

    //Utility method to mask card numbers
    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "************" + cardNumber.substring(cardNumber.length() - 4);
    }
}