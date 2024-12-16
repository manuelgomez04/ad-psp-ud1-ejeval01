package com.salesianostriana.dam.resteval;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private HashMap<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {


        add(Place.builder().name("Bar Paqui")
                .address("Calle Hermanos López")
                .coords("13654.00, 13545.00")
                .desc("Bar increíble")
                .image("sin_imagen.png").build());
        add(Place.builder().name("Bar Paqui")
                .address("Calle Hermanos López")
                .coords("13654.00, 13545.00")
                .desc("Bar increíble")
                .image("sin_imagen.png")
                .build()
        );
        add(Place.builder().name("Bar Paqui")
                .address("Calle Hermanos López")
                .coords("13654.00, 13545.00")
                .desc("Bar increíble")
                .image("sin_imagen.png")
                .build());


    }

    public Place add(Place place) {
        var id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return List.copyOf(places.values());
    }

    public Optional<Place> edit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k, v) -> {
            v.setName(place.getName());
            v.setDesc(place.getDesc());
            v.setImage(place.getImage());
            v.setCoords(place.getCoords());
            v.setAddress(place.getAddress());
            return v;
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }


}
