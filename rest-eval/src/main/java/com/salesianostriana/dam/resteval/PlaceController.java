package com.salesianostriana.dam.resteval;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/place")
public class PlaceController {


    private final PlaceService placeService;


    @GetMapping("/")
    public List<Place> getAllBares() {

        return placeService.getAll().getBody();
    }

    @GetMapping("/{id}")
    public Place getBar(@PathVariable Long id) {
        return placeService.get(id).getBody();
    }

    @PostMapping("/")
    public Place addBar(@RequestBody Place place) {
        return placeService.add(place).getBody();
    }

    @PutMapping("/{id}")
    public Place editBar(@PathVariable Long id, @RequestBody Place place) {
        return placeService.edit(id, place).getBody();
    }

    @PutMapping("/{id}/tag/add/{nuevo_tag}  ")
    public Place addTag(@PathVariable Long id, @PathVariable String nuevoTag) {
        placeService.get(id).getBody().addTag(nuevoTag);
        return placeService.get(id).getBody();
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public Place removeTag(@PathVariable Long id, @PathVariable String nuevoTag) {
        placeService.get(id).getBody().removeTag(nuevoTag);
        return placeService.get(id).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteBar(@PathVariable Long id) {
        placeService.delete(id);
    }

}
