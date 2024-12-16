package com.salesianostriana.dam.resteval;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;


    public ResponseEntity<List<Place>> getAll() {
        return ResponseEntity.ok(placeRepository.getAll());
    }

    public ResponseEntity <Place> add(Place place) {
        return ResponseEntity.ok(placeRepository.add(place));
    }

    public ResponseEntity<Place> edit(Long id, Place place) {

        return placeRepository.edit(id, place)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<Place> get(Long id) {

        return placeRepository.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void delete(Long id) {

            placeRepository.delete(id);

    }

}
