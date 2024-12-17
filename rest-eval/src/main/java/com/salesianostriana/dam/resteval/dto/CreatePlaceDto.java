package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.Place;

public record CreatePlaceDto(
        String name,
        String address,
        String coords,
        String image,
        String desc
) {

    /*public static Place toPlace(CreatePlaceDto dto) {
        return Place.builder().name(dto.name()).address(dto.address).coords(dto.coords).image(dto.image).desc(dto.description).build();
    }*/

    public  Place toPlace() {
        return Place.builder().name(this.name()).address(this.address).coords(this.coords).image(this.image).desc(this.desc).build();
    }
}
