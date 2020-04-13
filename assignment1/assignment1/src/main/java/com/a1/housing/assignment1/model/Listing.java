package com.a1.housing.assignment1.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class Listing {
    //street,city,zip,state,beds,baths,sq__ft,type,sale_date,price,latitude,longitude
    private String street;
    private String city;
    private Integer zip;
    private String state;
    private Integer beds;
    private Integer baths;
    private Integer sqFt;
    private String type;
    private Date date; //Wed May 21 00:00:00 EDT 2008
    private Double price;
    private Float latitude;
    private Float longitude;

    public Listing(){}

    public Listing(String street, String city, Integer zip, String state, Integer beds, Integer baths, Integer sqFt, String type, Date date, Double price, Float latitude, Float longitude) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.beds = beds;
        this.baths = baths;
        this.sqFt = sqFt;
        this.type = type;
        this.date = date;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
    }



}
