package com.example.case2bugrayus.service;

import com.example.case2bugrayus.model.City;
import com.example.case2bugrayus.model.request.CreateCityRequestModel;
import com.example.case2bugrayus.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    public boolean createCity(CreateCityRequestModel requestModel) {
        City city = getCityByPlate(requestModel.getPlateNumber());
        if (city != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "City already exists by that plate number");
        }
        cityRepository.save(mapper.map(requestModel, City.class));
        return true;
    }

    public City getCityByPlate(int plate) {
        List<City> cities =
                cityRepository
                        .findAll()
                        .stream()
                        .filter(x -> x.getPlateNumber() == plate)
                        .collect(Collectors.toList());
        if (cities.size() > 0) {
            return cities.get(0);
        }
        return null;
    }
}
