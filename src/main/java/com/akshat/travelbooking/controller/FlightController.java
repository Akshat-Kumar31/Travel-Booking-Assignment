package com.akshat.travelbooking.controller;

import com.akshat.travelbooking.dto.TravelOptionResponseDTO;
import com.akshat.travelbooking.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final SearchService searchService;

    public FlightController(SearchService searchService) {
        this.searchService = searchService;
    }

    //Get all flights
    @GetMapping("/all")
    public List<TravelOptionResponseDTO> getAllFlights() {
        return searchService.getAllFlights();
    }

    //Search flights from one place to another
    @GetMapping("/search")
    public List<TravelOptionResponseDTO> searchFlights(
            @RequestParam String from,
            @RequestParam String to) {

        return searchService.searchFlights(from, to);
    }
}