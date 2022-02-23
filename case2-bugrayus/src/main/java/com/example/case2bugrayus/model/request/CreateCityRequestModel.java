package com.example.case2bugrayus.model.request;

import lombok.Data;

@Data
public class CreateCityRequestModel {
    String name;
    int plateNumber;
    int countryId;
}
