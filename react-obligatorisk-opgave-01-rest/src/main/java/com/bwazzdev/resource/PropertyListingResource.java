package com.bwazzdev.resource;

import com.bwazzdev.domain.PropertyListing;
import com.bwazzdev.domain.PropertyType;
import com.bwazzdev.resource.dto.PropertyListingDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/property-listings")
public class PropertyListingResource {

    private Set<PropertyListing> propertyListings =
            Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    private Mapper mapper = new Mapper();

    public PropertyListingResource() {
        propertyListings.add(new PropertyListing(
                "pl0001",
                "Beautiful Family House",
                "USA",
                5,
                325,
                1200000,
                PropertyType.HOUSE,
                "https://imgur.com/Gvve4ir.jpg"));
        propertyListings.add(new PropertyListing(
                "pl0002",
                "Modern Glass Villa",
                "Canada",
                6,
                460,
                2750000,
                PropertyType.HOUSE,
                "https://imgur.com/zREdyfu.jpg"));
        propertyListings.add(new PropertyListing(
                "pl0003",
                "Cozy Country House",
                "UK",
                4,
                250,
                850000,
                PropertyType.HOUSE,
                "https://imgur.com/zIb5ToJ.jpg"));
        propertyListings.add(new PropertyListing(
                "pl0004",
                "Large Rustical Villa",
                "Portugal",
                6,
                480,
                1950000,
                PropertyType.HOUSE,
                "https://imgur.com/c3c5V7i.jpg"));
        propertyListings.add(new PropertyListing(
                "pl0005",
                "Majestic Palace House",
                "Germany",
                8,
                4230,
                9500000,
                PropertyType.HOUSE,
                "https://imgur.com/V28bUNq.jpg"));
        propertyListings.add(new PropertyListing(
                "pl0006",
                "Modern Family Apartment",
                "Italy",
                3,
                180,
                600000,
                PropertyType.APARTMENT,
                "https://imgur.com/Qsf4spy.jpg"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<PropertyListingDTO> getPropertyListings() {
        return propertyListings.stream().map(mapper::toPropertyListingDTO).collect(Collectors.toSet());
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public PropertyListingDTO getProp(@PathParam("id") String id) {
        return propertyListings.stream()
                .filter(propertyListing -> propertyListing.getId().equals(id))
                .map(mapper::toPropertyListingDTO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No property listing with id %s", id)));
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PropertyListingDTO createPropertyListing(PropertyListingDTO propertyListingDTO) {
        PropertyListing propertyListing = mapper.toPropertyListing(propertyListingDTO);
        propertyListings.add(propertyListing);
        return mapper.toPropertyListingDTO(propertyListing);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public PropertyListingDTO removePropertyListing(@PathParam("id") String id) {
        PropertyListing pl = propertyListings.stream()
                .filter(propertyListing -> propertyListing.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No property listing with id %s", id)));
        propertyListings.remove(pl);
        return mapper.toPropertyListingDTO(pl);
    }
}
