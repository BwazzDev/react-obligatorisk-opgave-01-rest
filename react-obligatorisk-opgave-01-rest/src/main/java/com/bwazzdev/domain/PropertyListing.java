package com.bwazzdev.domain;

import java.util.Random;

public class PropertyListing {
    private final String id;
    private final String name;
    private final String location;
    private final int rooms;
    private final int area;
    private final int price;
    private final PropertyType propertyType;
    private final String imgUrl;

    public PropertyListing(String id, String name, String location, int rooms, int area, int price,
                           PropertyType propertyType, String imgUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.propertyType = propertyType;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getLocation() {
        return location;
    }

    public int getRooms() {
        return rooms;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
