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

    public Place addTagToPlace(Long id, String tag) {
        // Buscar el place
        // Añadir el tag
        // Modificar el place
        Optional<Place> placeOpt = placeRepository.get(id);
        Place place = null;
        if (placeOpt.isPresent()) {
            place = placeOpt.get();
            place.addTag(tag);
            placeRepository.edit(id, place);
        } else {
            new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id));
        }
        return place;
    }

    public Place deleteTagFromPlace(Long id, String tag) {
        // Buscar el place
        // Eliminar el tag
        // Modificar el place
        Optional<Place> placeOpt = placeRepository.get(id);
        Place place = null;
        if (placeOpt.isPresent()) {
            place = placeOpt.get();
            place.removeTag(tag);
            placeRepository.edit(id, place);
        } else {
            throw new PlaceNotFoundException("No se ha podido encontrar el lugar con ID %d".formatted(id));
        }
        return place;

    }

    public Place getById(Long id) {
        Optional<Place> result = placeRepository.get(id);

        return placeRepository.get(id).orElseThrow(() -> new PlaceNotFoundException("No hay bar con ese id"));
    }

    public void delete(Long id) {

        placeRepository.delete(id);

    }

}
