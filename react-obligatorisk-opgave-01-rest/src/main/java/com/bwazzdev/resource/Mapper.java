package com.bwazzdev.resource;

import com.bwazzdev.domain.PropertyListing;
import com.bwazzdev.resource.dto.PropertyListingDTO;

public class Mapper {
    public PropertyListingDTO toPropertyListingDTO(PropertyListing propertyListing) {
        return new PropertyListingDTO(
                propertyListing.getId(),
                propertyListing.getName(),
                propertyListing.getLocation(),
                propertyListing.getRooms(),
                propertyListing.getArea(),
                propertyListing.getPrice(),
                propertyListing.getPropertyType(),
                propertyListing.getImgUrl()
        );
    }

    public PropertyListing toPropertyListing(PropertyListingDTO propertyListingDTO) {
        return new PropertyListing(
                propertyListingDTO.getId(),
                propertyListingDTO.getName(),
                propertyListingDTO.getLocation(),
                propertyListingDTO.getRooms(),
                propertyListingDTO.getArea(),
                propertyListingDTO.getPrice(),
                propertyListingDTO.getPropertyType(),
                propertyListingDTO.getImgUrl()
        );
    }
}
