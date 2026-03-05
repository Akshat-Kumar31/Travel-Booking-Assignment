package com.akshat.travelbooking.dto;

public class PaymentResponseDTO {

    private Long paymentId;
    private Long bookingId;
    private Double amount;
    private String status;
    private String maskedCardNumber; // new field

    public PaymentResponseDTO(Long paymentId, Long bookingId,
                              Double amount, String status,
                              String maskedCardNumber) { // updated constructor
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
        this.maskedCardNumber = maskedCardNumber;
    }

    // getters
    public Long getPaymentId() { return paymentId; }
    public Long getBookingId() { return bookingId; }
    public Double getAmount() { return amount; }
    public String getStatus() { return status; }
    public String getMaskedCardNumber() { return maskedCardNumber; } // new getter
}