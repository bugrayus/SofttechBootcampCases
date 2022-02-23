package com.example.case2bugrayus.controller;

import com.example.case2bugrayus.model.*;
import com.example.case2bugrayus.model.request.*;
import com.example.case2bugrayus.model.response.GetAddressResponseModel;
import com.example.case2bugrayus.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final CountryService countryService;
    private final CityService cityService;
    private final DistrictService districtService;
    private final QuarterService quarterService;
    private final StreetService streetService;

    //Proje yapımda booelan alanlarda true dönerim. False dönmeme sebebim eğer bir hata olduysa throw yapar clienta hata mesajı dönerim.
    //Vakit kaybını önlerim. Program counter(assembly mantığı) olduğu yerde metoddan çıkar.

    //Address Methods************************************************************************
    @Nullable
    @GetMapping("/address/{id}")
    public GetAddressResponseModel getAddress(@PathVariable int id) {
        return addressService.getAddress(id);
    }

    @PostMapping("/address")
    public boolean createAddress(@RequestBody CreateAddressRequestModel requestModel) {
        return addressService.createAddress(requestModel);
    }

    @DeleteMapping("/address/{id}")
    public boolean createAddress(@PathVariable int id) {
        return addressService.deleteAddress(id);
    }

    //Country Methods**************************************************************************
    @PostMapping("/country")
    public boolean createCountry(@RequestBody CreateCountryRequestModel requestModel) {
        return countryService.createCountry(requestModel);
    }

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable int code) {
        return countryService.getCountryByCode(code);
    }

    //City Methods*****************************************************************************
    @PostMapping("/city")
    public boolean createCity(@RequestBody CreateCityRequestModel requestModel) {
        return cityService.createCity(requestModel);
    }

    @GetMapping("/city/{plate}")
    public City getCityByPlate(@PathVariable int plate) {
        return cityService.getCityByPlate(plate);
    }

    //District Methods*************************************************************************
    @PostMapping("/district")
    public boolean createDistrict(@RequestBody CreateDistrictRequestModel requestModel) {
        return districtService.createDistrict(requestModel);
    }

    @GetMapping("/district/{cityId}")
    public List<District> getDistrictsByCity(@PathVariable int cityId) {
        return districtService.getDistrictsByCity(cityId);
    }

    //Quarter Methods**************************************************************************
    @PostMapping("/quarter")
    public boolean createQuarter(@RequestBody CreateQuarterRequestModel requestModel) {
        return quarterService.createQuarter(requestModel);
    }

    @GetMapping("/quarter/{districtId}")
    public List<Quarter> getQuartersByDistrict(@PathVariable int districtId) {
        return quarterService.getQuartersByDistrict(districtId);
    }

    @PutMapping("/quarter")
    public boolean updateQuarterName(@RequestBody UpdateQuarterRequestModel requestModel) {
        return quarterService.updateQuarterName(requestModel);
    }

    //Street Methods******************************************************************************
    @PostMapping("/street")
    public boolean createStreet(@RequestBody CreateStreetRequestModel requestModel) {
        return streetService.createStreet(requestModel);
    }

    @GetMapping("/street/{quarterId}")
    public List<Street> getStreetsByQuarter(@PathVariable int quarterId) {
        return streetService.getStreetsByQuarter(quarterId);
    }

    @PutMapping("/street")
    public boolean updateStreetName(@RequestBody UpdateStreetRequestModel requestModel) {
        return streetService.updateStreetName(requestModel);
    }
}
