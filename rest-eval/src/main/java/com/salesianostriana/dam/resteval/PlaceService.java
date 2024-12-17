package com.salesianostriana.dam.resteval;

import com.salesianostriana.dam.resteval.dto.ListGetPlaceDto;
import com.salesianostriana.dam.resteval.error.PlaceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;


    public ListGetPlaceDto getAll() {

        List<Place> result = placeRepository.getAll();
        if (result.isEmpty()) {
            throw new PlaceNotFoundException("No hay bares");
        }
        return ListGetPlaceDto.of(result);
    }

    public Place add(Place place) {
        return placeRepository.add(place);
    }

    public Place edit(Long id, Place place) {

        return placeRepository.edit(id, place).orElseThrow(() -> new PlaceNotFoundException("No se ha encontrado"));

    }

    public Place addTag(Long id, String tag) {

        Optional<Place> place =
        if(placeOpt.)
    }

    public Place getById(Long id) {
        Optional<Place> result = placeRepository.get(id);

        return placeRepository.get(id).orElseThrow(() -> new PlaceNotFoundException("No hay bar con ese id"));
    }

    public void delete(Long id) {

        placeRepository.delete(id);

    }

}
