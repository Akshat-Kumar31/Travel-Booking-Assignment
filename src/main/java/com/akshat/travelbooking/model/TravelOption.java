package com.akshat.travelbooking.model;


public class TravelOption {

    private Long id;
    private String type;
    private String fromLocation;
    private String toLocation;
    private Double price;
    private String departureTime;

    public TravelOption(Long id, String type, String fromLocation,
                        String toLocation, Double price, String departureTime) {
        this.id = id;
        this.type = type;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.price = price;
        this.departureTime = departureTime;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getFromLocation() { return fromLocation; }
    public String getToLocation() { return toLocation; }
    public Double getPrice() { return price; }
    public String getDepartureTime() { return departureTime; }
}
