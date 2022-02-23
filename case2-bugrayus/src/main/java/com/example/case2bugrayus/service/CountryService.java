package com.example.case2bugrayus.service;

import com.example.case2bugrayus.model.Country;
import com.example.case2bugrayus.model.request.CreateCountryRequestModel;
import com.example.case2bugrayus.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper mapper;

    public Country getCountryByCode(int code) {
        List<Country> countries =
                countryRepository
                        .findAll()
                        .stream()
                        .filter(x -> x.getCountryCode() == code)
                        .collect(Collectors.toList());
        if (countries.size() > 0) {
            return countries.get(0);
        }
        return null;
    }

    public boolean createCountry(CreateCountryRequestModel requestModel) {
        Country country = getCountryByCode(requestModel.getCountryCode());
        if (country != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Country already exists by that country code");
        }
        countryRepository.save(mapper.map(requestModel, Country.class));
        return true;
    }
}
