package com.example.case2bugrayus.model.request;

import lombok.Data;

@Data
public class CreateAddressRequestModel {
    int doorNumber;
    int apartmentNumber;
    String name;
    int countryId;
    int cityId;
    int districtId;
    int quarterId;
    int streetId;
}
