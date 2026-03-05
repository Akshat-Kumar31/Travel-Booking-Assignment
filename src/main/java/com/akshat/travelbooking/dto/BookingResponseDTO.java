package com.akshat.travelbooking.dto;

public class BookingResponseDTO {

    private Long bookingId;
    private Long travelOptionId;
    private String passengerName;
    private String status;

    public BookingResponseDTO() {
    }

    public BookingResponseDTO(Long bookingId, Long travelOptionId, String passengerName, String status) {
        this.bookingId = bookingId;
        this.travelOptionId = travelOptionId;
        this.passengerName = passengerName;
        this.status = status;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getTravelOptionId() {
        return travelOptionId;
    }

    public void setTravelOptionId(Long travelOptionId) {
        this.travelOptionId = travelOptionId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}