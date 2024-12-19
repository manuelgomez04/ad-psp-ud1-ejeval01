package com.salesianostriana.dam.resteval;

import com.salesianostriana.dam.resteval.dto.CreatePlaceDto;
import com.salesianostriana.dam.resteval.dto.GetPlaceDTO;
import com.salesianostriana.dam.resteval.dto.ListGetPlaceDto;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@AllArgsConstructor
@RequestMapping("/place")
public class PlaceController {


    private final PlaceService placeService;


    @GetMapping("/")
    public ListGetPlaceDto getAllBares() {

        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public Place getBar(@PathVariable Long id) {
        return placeService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Place> addBar(@RequestBody CreatePlaceDto dto) {
        return ResponseEntity.status(201).body(placeService.add(dto.toPlace()));
    }

    @PutMapping("/{id}")
    public Place editBar(@PathVariable Long id, @RequestBody CreatePlaceDto dto) {
        return placeService.edit(id, dto.toPlace());
    }

    @PutMapping("{id}/tag/add/{tag}")
    public Place addTag(
            @PathVariable Long id,
            @PathVariable String tag
    ) {
        return placeService.addTagToPlace(id, tag);
    }

    @PutMapping("{id}/tag/del/{tag}")
    public Place delTag(
            @PathVariable Long id,
            @PathVariable String tag
    ) {
        return placeService.deleteTagFromPlace(id, tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBar(@PathVariable Long id) {

        placeService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
