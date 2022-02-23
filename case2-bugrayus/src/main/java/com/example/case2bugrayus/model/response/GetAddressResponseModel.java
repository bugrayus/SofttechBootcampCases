package com.example.case2bugrayus.model.response;

import com.example.case2bugrayus.model.*;
import lombok.Data;

@Data
public class GetAddressResponseModel {
    int doorNumber;
    int apartmentNumber;
    String name;
    Country country;
    City city;
    District district;
    Quarter quarter;
    Street street;
    private Long id;
}
