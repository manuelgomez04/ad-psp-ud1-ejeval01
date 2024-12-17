package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.Place;

public record GetPlaceDTO(
        Long id,
        String address,
        String name,
        String image,
        String coords

) {
    public static GetPlaceDTO of(Place place) {
        return new GetPlaceDTO(
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getImage(),
                place.getCoords()
        );
    }
}
