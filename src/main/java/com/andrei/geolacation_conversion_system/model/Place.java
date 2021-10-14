package com.andrei.geolacation_conversion_system.model;

import com.google.maps.model.LatLng;

import java.io.Serializable;
import java.util.Objects;

public class Place implements Serializable {

    private final String address;
    private final LatLng coordinates;

    public Place(String address, LatLng coordinates) {
        this.address = address;
        this.coordinates = coordinates;
    }

    public String getAddress() {
        return address;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(address, place.address) && Objects.equals(coordinates, place.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, coordinates);
    }

    @Override
    public String toString() {
        return "Place{" +
                "address='" + address + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
