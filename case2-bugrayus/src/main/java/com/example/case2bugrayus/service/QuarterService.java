package com.example.case2bugrayus.service;

import com.example.case2bugrayus.model.Quarter;
import com.example.case2bugrayus.model.request.CreateQuarterRequestModel;
import com.example.case2bugrayus.model.request.UpdateQuarterRequestModel;
import com.example.case2bugrayus.repository.QuarterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuarterService {
    private final QuarterRepository quarterRepository;
    private final ModelMapper mapper;

    public boolean createQuarter(CreateQuarterRequestModel requestModel) {
        quarterRepository.save(mapper.map(requestModel, Quarter.class));
        return true;
    }

    public List<Quarter> getQuartersByDistrict(int districtId) {
        List<Quarter> quarters = quarterRepository.findAll();
        return quarters
                .stream()
                .filter(x -> x.getDistrict().getId() == districtId)
                .collect(Collectors.toList());
    }

    public boolean updateQuarterName(UpdateQuarterRequestModel requestModel) {
        Quarter quarter = quarterRepository.getById(requestModel.getId());
        quarter.setName(requestModel.getName());
        quarterRepository.save(quarter);
        return true;
    }
}
