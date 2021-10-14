package com.andrei.geolacation_conversion_system.repository.simple_repository;

import com.andrei.geolacation_conversion_system.model.Place;
import com.andrei.geolacation_conversion_system.repository.PlaceRepository;
import com.andrei.geolacation_conversion_system.service.GoogleMapService;
import com.google.maps.model.LatLng;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimplePlaceRepository implements PlaceRepository {
    @Override
    @Cacheable(value = "place")
    public Place getByAddress(String address) {
        GoogleMapService googleMapService = new GoogleMapService();
        LatLng coordinates = googleMapService.findCoordinatesByAddress(address);
        return new Place(address, coordinates);
    }

    @Override
    @Cacheable(value = "place")
    public Place getByCoordinates(LatLng coordinates) {
        GoogleMapService googleMapService = new GoogleMapService();
        String address = googleMapService.findAddressByCoordinates(coordinates);
        return new Place(address, coordinates);
    }
}
