package com.andrei.geolacation_conversion_system.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleMapService {

    private final static String KEY_FOR_GEO_API_CONTEXT = "AIzaSyCMCmt1zCOekyW14T50EcTLvaGBsHI_T-o";

    public LatLng findCoordinatesByAddress(String address) {
        GeoApiContext context = getContext();
        GeocodingResult[] results = new GeocodingResult[0];
        double lat = 1;
        double lng = 1;
        try {
            results = GeocodingApi.geocode(context, address).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        try {
            lat = results[0].geometry.location.lat;
            lng = results[0].geometry.location.lng;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        context.shutdown();
        return new LatLng(lat, lng);
    }

    public String findAddressByCoordinates(LatLng coordinates) {
        GeoApiContext context = getContext();
        GeocodingResult[] addresses = new GeocodingResult[0];
        String address = "";
        try {
            addresses = GeocodingApi.reverseGeocode(context, coordinates).await();
        } catch (ApiException | InterruptedException | IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            address = addresses[0].formattedAddress;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        context.shutdown();
        return address;
    }

    private GeoApiContext getContext() {
        return new GeoApiContext.Builder().apiKey(KEY_FOR_GEO_API_CONTEXT).build();
    }
}
