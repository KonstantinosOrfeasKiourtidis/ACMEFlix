package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.AddressMapper;
import com.team5.ACMEFlix.service.AddressService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.AddressResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account/address")
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Autowired
    private AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AddressResource>>> findAllAddresses(){
        return new ResponseEntity<>(ApiResponse.<List<AddressResource>>builder().data(addressMapper.toResources(addressService.findAllAddresses())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<AddressResource>> findAddressById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<AddressResource>builder().data(addressMapper.toResource(addressService.findAddressById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllAddressesByAccountId/{id}")
    public ResponseEntity<ApiResponse<List<AddressResource>>> findAllAddressesByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<List<AddressResource>>builder().data(addressMapper.toResources(addressService.findAllAddressesByAccountId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addAddressByAccountId/{id}")
    public ResponseEntity<ApiResponse<AddressResource>> addAddressByAccountId(@PathVariable("id") Long id, @Valid @RequestBody AddressResource address){
        return new ResponseEntity<>(ApiResponse.<AddressResource>builder().data(addressMapper.toResource(addressService.addAddressByAccountId(id, addressMapper.toDomain(address)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addAddressesByAccountId/{id}")
    public ResponseEntity<ApiResponse<List<AddressResource>>> addAddressesByAccountId(@PathVariable("id") Long id, @Valid @RequestBody List<AddressResource> addresses){
        return new ResponseEntity<>(ApiResponse.<List<AddressResource>>builder().data(addressMapper.toResources(addressService.addAddressesByAccountId(id, addressMapper.toDomains(addresses)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAddressById/{id}")
    public void deleteAddressById(@PathVariable("id") Long id){
        addressService.deleteAddressById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAddressesByIds/{ids}")
    public void deleteAddressesByIds(@PathVariable("ids") List<Long> ids){
        addressService.deleteAddressesByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateAddressById/{id}")
    public void updateAddressById(
            @PathVariable("id") Long id,
            @Valid @RequestBody AddressResource address
    ){
        addressService.updateAddressById(id, addressMapper.toDomain(address));
    }
}
