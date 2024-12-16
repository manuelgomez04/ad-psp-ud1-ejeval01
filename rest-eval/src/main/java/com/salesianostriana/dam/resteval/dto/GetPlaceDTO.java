package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.Place;

public record GetPlaceDTO(
        String name,
        String address,
        String desc,
        String image,
        String coords

) {
    /*
    public Place createFromPlace(Place place) {
        return new Place (place.getId(), name, address, coords, place.getTags(), desc, image);
    }*/
}
