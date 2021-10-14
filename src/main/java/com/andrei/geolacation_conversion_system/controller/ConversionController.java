package com.andrei.geolacation_conversion_system.controller;

import com.andrei.geolacation_conversion_system.model.Place;
import com.andrei.geolacation_conversion_system.repository.PlaceRepository;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConversionController {

    private final PlaceRepository placeRepository;

    public ConversionController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("coordinates", " ");
        model.addAttribute("address", " ");
        return "main";
    }

    @PostMapping(value = "findCoordinates")
    public String findCoordinates(String address, Model model) {
        Place place = placeRepository.getByAddress(address);
        model.addAttribute("coordinates", place.getCoordinates().toString());
        model.addAttribute("address", " ");
        return "main";
    }

    @PostMapping(value = "findAddress")
    public String findAddress(String lat, String lng, Model model) {
        double latitude = 1;
        double longitude = 1;
        try {
            latitude = Double.parseDouble(lat);
            longitude = Double.parseDouble(lng);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        LatLng coordinates = new LatLng(latitude, longitude);
        Place place = placeRepository.getByCoordinates(coordinates);
        model.addAttribute("address", place.getAddress());
        model.addAttribute("coordinates", " ");
        return "main";
    }
}
