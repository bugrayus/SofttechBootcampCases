package com.example.case2bugrayus.service;

import com.example.case2bugrayus.model.Street;
import com.example.case2bugrayus.model.request.CreateStreetRequestModel;
import com.example.case2bugrayus.model.request.UpdateStreetRequestModel;
import com.example.case2bugrayus.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StreetService {
    private final StreetRepository streetRepository;
    private final ModelMapper mapper;

    public boolean createStreet(CreateStreetRequestModel requestModel) {
        streetRepository.save(mapper.map(requestModel, Street.class));
        return true;
    }

    public List<Street> getStreetsByQuarter(int quarterId) {
        List<Street> streets = streetRepository.findAll();
        return streets
                .stream()
                .filter(x -> x.getQuarter().getId() == quarterId)
                .collect(Collectors.toList());
    }

    public boolean updateStreetName(UpdateStreetRequestModel requestModel) {
        Street street = streetRepository.getById(requestModel.getId());
        street.setName(requestModel.getName());
        streetRepository.save(street);
        return true;
    }
}
