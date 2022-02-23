package com.example.case2bugrayus.service;

import com.example.case2bugrayus.model.District;
import com.example.case2bugrayus.model.request.CreateDistrictRequestModel;
import com.example.case2bugrayus.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final ModelMapper mapper;

    public boolean createDistrict(CreateDistrictRequestModel requestModel) {
        districtRepository.save(mapper.map(requestModel, District.class));
        return true;
    }

    public List<District> getDistrictsByCity(int cityId) {
        List<District> districts = districtRepository.findAll();
        return districts
                .stream()
                .filter(x -> x.getCity().getId() == cityId)
                .collect(Collectors.toList());
    }
}
