package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.Place;

import java.util.List;

public record ListGetPlaceDto(
        long count,
        List<GetPlaceDTO> items
) {

    public static ListGetPlaceDto of(List<Place> list) {
        return new ListGetPlaceDto(
                list.size(),
                list.stream().map(GetPlaceDTO::of).toList()
        );
    }
}
