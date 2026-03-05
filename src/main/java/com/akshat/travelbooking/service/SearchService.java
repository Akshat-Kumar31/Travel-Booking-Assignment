package com.akshat.travelbooking.service;

import com.akshat.travelbooking.dto.TravelOptionResponseDTO;
import com.akshat.travelbooking.exception.ResourceNotFoundException;
import com.akshat.travelbooking.model.TravelOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final List<TravelOption> travelOptions = new ArrayList<>();


    //Dummy(static) data for travel options
    public SearchService() {
        travelOptions.add(new TravelOption(1L, "TRAIN", "Delhi", "Mumbai", 1500.0, "10:00 AM"));
        travelOptions.add(new TravelOption(2L, "FLIGHT", "Delhi", "Pune", 5500.0, "6:00 PM"));
        travelOptions.add(new TravelOption(3L, "TRAIN", "Noida", "Jaipur", 800.0, "9:00 AM"));
        travelOptions.add(new TravelOption(4L, "FLIGHT", "Pune", "Delhi", 5200.0, "8:00 PM"));
        travelOptions.add(new TravelOption(5L, "TRAIN", "Mumbai", "Pune", 1300.0, "10:30 AM"));
        travelOptions.add(new TravelOption(6L, "FLIGHT", "Bangalore", "Delhi", 6400.0, "1:00 PM"));
    }


    //Method to search for trains from one place to another
    public List<TravelOptionResponseDTO> searchTrains(String from, String to) {

        List<TravelOption> results = travelOptions.stream()
                .filter(option ->
                        option.getType().equalsIgnoreCase("TRAIN")
                                && option.getFromLocation().equalsIgnoreCase(from)
                                && option.getToLocation().equalsIgnoreCase(to))
                .collect(Collectors.toList());


        //Throws exception if there is no train between the given places
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No trains found from " + from + " to " + to);
        }

        return results.stream()
                .map(option -> new TravelOptionResponseDTO(
                        option.getId(),
                        option.getType(),
                        option.getFromLocation(),
                        option.getToLocation(),
                        option.getPrice(),
                        option.getDepartureTime()
                ))
                .collect(Collectors.toList());
    }


    //Method to search for flights from one place to another
    public List<TravelOptionResponseDTO> searchFlights(String from, String to) {

        List<TravelOption> results = travelOptions.stream()
                .filter(option ->
                        option.getType().equalsIgnoreCase("FLIGHT")
                                && option.getFromLocation().equalsIgnoreCase(from)
                                && option.getToLocation().equalsIgnoreCase(to))
                .collect(Collectors.toList());


        //Throws exception if there is no flight between the given places
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No flights found from " + from + " to " + to);
        }

        return results.stream()
                .map(option -> new TravelOptionResponseDTO(
                        option.getId(),
                        option.getType(),
                        option.getFromLocation(),
                        option.getToLocation(),
                        option.getPrice(),
                        option.getDepartureTime()
                ))
                .collect(Collectors.toList());
    }


    //Method to get all trains
    public List<TravelOptionResponseDTO> getAllTrains() {

        List<TravelOption> results = travelOptions.stream()
                .filter(option -> option.getType().equalsIgnoreCase("TRAIN"))
                .toList();


        //Checks if there are any trains or not. If not, then this exception is thrown
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No trains available");
        }

        return results.stream()
                .map(option -> new TravelOptionResponseDTO(
                        option.getId(),
                        option.getType(),
                        option.getFromLocation(),
                        option.getToLocation(),
                        option.getPrice(),
                        option.getDepartureTime()
                ))
                .toList();
    }


    //Method to get all flights
    public List<TravelOptionResponseDTO> getAllFlights() {

        List<TravelOption> results = travelOptions.stream()
                .filter(option -> option.getType().equalsIgnoreCase("FLIGHT"))
                .toList();


        //Checks if there are any flights or not. If not, then this exception is thrown
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No flights available");
        }

        return results.stream()
                .map(option -> new TravelOptionResponseDTO(
                        option.getId(),
                        option.getType(),
                        option.getFromLocation(),
                        option.getToLocation(),
                        option.getPrice(),
                        option.getDepartureTime()
                ))
                .toList();
    }


    //Method to get travel options by travel option Id
    public TravelOption getById(Long id) {
        return travelOptions.stream()
                .filter(option -> option.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Travel option not found with id: " + id));
    }
}