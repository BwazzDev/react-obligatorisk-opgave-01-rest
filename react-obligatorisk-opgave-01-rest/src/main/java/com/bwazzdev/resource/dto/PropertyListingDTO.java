package com.bwazzdev.resource.dto;

import com.bwazzdev.domain.PropertyType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyListingDTO {
    private final String id;
    private final String name;
    private final String location;
    private final int rooms;
    private final int area;
    private final int price;
    private final PropertyType propertyType;
    private final String imgUrl;

    @JsonCreator
    public PropertyListingDTO(String id, String name, String location, int rooms, int area, int price, PropertyType propertyType, String imgUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.propertyType = propertyType;
        this.imgUrl = imgUrl;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getLocation() {
        return location;
    }

    @JsonProperty
    public int getRooms() {
        return rooms;
    }

    @JsonProperty
    public int getArea() {
        return area;
    }

    @JsonProperty
    public int getPrice() {
        return price;
    }

    @JsonProperty
    public PropertyType getPropertyType() {
        return propertyType;
    }

    @JsonProperty
    public String getImgUrl() {
        return imgUrl;
    }
}
