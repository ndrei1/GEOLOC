package com.andrei.geolacation_conversion_system.service;

import com.google.maps.model.LatLng;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoogleMapServiceTest {

    @Test
    void shouldReturnCorrectCoordinate() {
        GoogleMapService googleMapService = new GoogleMapService();
        String address = "Минск, Одинцова 43";
        LatLng actual = googleMapService.findCoordinatesByAddress(address);
        LatLng expected = new LatLng(53.89792050, 27.44324950);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectAddress() {
        GoogleMapService googleMapService = new GoogleMapService();
        String expected = "vul. Adzincova 43, Minsk, Belarus";
        LatLng coordinates = new LatLng(53.89792050, 27.44324950);
        String actual = googleMapService.findAddressByCoordinates(coordinates);
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowNullPointerException() {
        GoogleMapService googleMapService = new GoogleMapService();
        Assertions.assertThrows(NullPointerException.class, () -> {
            googleMapService.findCoordinatesByAddress(null);
        });
    }
}