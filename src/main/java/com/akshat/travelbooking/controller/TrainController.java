package com.akshat.travelbooking.controller;

import com.akshat.travelbooking.dto.TravelOptionResponseDTO;
import com.akshat.travelbooking.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trains")
public class TrainController {

    private final SearchService searchService;

    public TrainController(SearchService searchService) {
        this.searchService = searchService;
    }


    //Get all trains
    @GetMapping("/all")
    public List<TravelOptionResponseDTO> getAllTrains() {
        return searchService.getAllTrains();
    }


    //Get trains from one place to another
    @GetMapping("/search")
    public List<TravelOptionResponseDTO> searchTrains(
            @RequestParam String from,
            @RequestParam String to) {

        return searchService.searchTrains(from, to);
    }
}