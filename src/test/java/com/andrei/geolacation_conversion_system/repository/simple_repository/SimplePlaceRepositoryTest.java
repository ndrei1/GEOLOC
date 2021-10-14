package com.andrei.geolacation_conversion_system.repository.simple_repository;


import com.andrei.geolacation_conversion_system.model.Place;
import com.google.maps.model.LatLng;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplePlaceRepositoryTest {
    @Test
    void shouldReturnCorrectPlaceByAddress() {
        SimplePlaceRepository simplePlaceRepository = new SimplePlaceRepository();
        Place expectedPlace = new Place("Минск, Одинцова 43", new LatLng(53.89792050, 27.44324950));
        Place actualPlace = simplePlaceRepository.getByAddress("Минск, Одинцова 43");
        assertEquals(expectedPlace, actualPlace);

    }

    @Test
    void shouldReturnCorrectPlaceByCoordinate() {
        SimplePlaceRepository simplePlaceRepository = new SimplePlaceRepository();
        Place expectedPlace = new Place("vul. Adzincova 43, Minsk, Belarus", new LatLng(53.89792050, 27.44324950));
        Place actualPlace = simplePlaceRepository.getByCoordinates(new LatLng(53.89792050, 27.44324950));
        assertEquals(expectedPlace, actualPlace);
    }
}