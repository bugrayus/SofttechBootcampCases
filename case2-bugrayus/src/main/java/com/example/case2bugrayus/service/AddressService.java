package com.example.case2bugrayus.service;

import com.example.case2bugrayus.model.Address;
import com.example.case2bugrayus.model.request.CreateAddressRequestModel;
import com.example.case2bugrayus.model.response.GetAddressResponseModel;
import com.example.case2bugrayus.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    public GetAddressResponseModel getAddress(int id) {
        if (!addressRepository.existsById((long) id))
            return null;
        return mapper.map(addressRepository.getById((long) id), GetAddressResponseModel.class);
    }

    public boolean createAddress(CreateAddressRequestModel requestModel) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        addressRepository.save(mapper.map(requestModel, Address.class));
        return true;
    }

    public boolean deleteAddress(int id) {
        if (!addressRepository.existsById((long) id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found by that id");
        addressRepository.deleteById((long) id);
        return true;
    }
}
