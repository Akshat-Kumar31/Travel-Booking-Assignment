package com.akshat.travelbooking.controller;

import com.akshat.travelbooking.service.BookingService;
import com.akshat.travelbooking.service.PaymentService;
import com.akshat.travelbooking.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    private final SearchService searchService;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public HealthController(
            SearchService searchService,
            BookingService bookingService,
            PaymentService paymentService
    ) {
        this.searchService = searchService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    @GetMapping("/api/v1/health")
    public Map<String, Object> healthCheck() {

        Map<String, Object> response = new HashMap<>();

        boolean servicesHealthy =
                searchService != null &&
                        bookingService != null &&
                        paymentService != null;

        response.put("status", servicesHealthy ? "UP" : "DOWN");
        response.put("service", "Travel Booking System");
        response.put("timestamp", LocalDateTime.now());

        Map<String, String> services = new HashMap<>();
        services.put("searchService", "UP");
        services.put("bookingService", "UP");
        services.put("paymentService", "UP");

        response.put("components", services);

        return response;
    }
}