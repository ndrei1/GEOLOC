package com.andrei.geolacation_conversion_system.repository;

import com.andrei.geolacation_conversion_system.model.Place;
import com.google.maps.model.LatLng;


public interface PlaceRepository {

    Place getByAddress(String address);

    Place getByCoordinates(LatLng coordinates);

}
