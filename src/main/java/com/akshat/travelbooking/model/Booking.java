package com.akshat.travelbooking.model;


public class Booking {

    private Long id;
    private Long travelOptionId;
    private String passengerName;
    private String status;

    public Booking() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTravelOptionId() { return travelOptionId; }
    public void setTravelOptionId(Long travelOptionId) { this.travelOptionId = travelOptionId; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
