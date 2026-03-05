package com.akshat.travelbooking.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingRequestDTO {

    @NotNull(message = "travelOptionId is required")
    private Long travelOptionId;

    @NotBlank(message = "passengerName is required")
    private String passengerName;

    public Long getTravelOptionId() { return travelOptionId; }
    public void setTravelOptionId(Long travelOptionId) { this.travelOptionId = travelOptionId; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
}
