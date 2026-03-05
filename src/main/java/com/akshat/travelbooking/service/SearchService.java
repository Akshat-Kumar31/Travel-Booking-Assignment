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

    public SearchService() {
        travelOptions.add(new TravelOption(1L, "TRAIN", "Delhi", "Mumbai", 1500.0, "10:00 AM"));
        travelOptions.add(new TravelOption(2L, "FLIGHT", "Delhi", "Pune", 5500.0, "6:00 PM"));
        travelOptions.add(new TravelOption(3L, "TRAIN", "Noida", "Jaipur", 800.0, "9:00 AM"));
        travelOptions.add(new TravelOption(4L, "FLIGHT", "Pune", "Delhi", 5200.0, "8:00 PM"));
        travelOptions.add(new TravelOption(5L, "TRAIN", "Mumbai", "Pune", 1300.0, "10:30 AM"));
        travelOptions.add(new TravelOption(6L, "FLIGHT", "Bangalore", "Delhi", 6400.0, "1:00 PM"));
    }

    public List<TravelOptionResponseDTO> searchTrains(String from, String to) {

        List<TravelOption> results = travelOptions.stream()
                .filter(option ->
                        option.getType().equalsIgnoreCase("TRAIN")
                                && option.getFromLocation().equalsIgnoreCase(from)
                                && option.getToLocation().equalsIgnoreCase(to))
                .collect(Collectors.toList());

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

    public List<TravelOptionResponseDTO> searchFlights(String from, String to) {

        List<TravelOption> results = travelOptions.stream()
                .filter(option ->
                        option.getType().equalsIgnoreCase("FLIGHT")
                                && option.getFromLocation().equalsIgnoreCase(from)
                                && option.getToLocation().equalsIgnoreCase(to))
                .collect(Collectors.toList());

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

    public List<TravelOptionResponseDTO> getAllTrains() {

        List<TravelOption> results = travelOptions.stream()
                .filter(option -> option.getType().equalsIgnoreCase("TRAIN"))
                .toList();

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

    public List<TravelOptionResponseDTO> getAllFlights() {

        List<TravelOption> results = travelOptions.stream()
                .filter(option -> option.getType().equalsIgnoreCase("FLIGHT"))
                .toList();

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

    public TravelOption getById(Long id) {
        return travelOptions.stream()
                .filter(option -> option.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Travel option not found with id: " + id));
    }
}